package com.example.csc415.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.csc415.R
import com.example.csc415.viewModel.AlbumViewModel
import com.example.csc415.databinding.FragmentAlbumListBinding
import com.example.csc415.ui.adapter.AlbumAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AlbumListFragment : Fragment() {

    private var _binding: FragmentAlbumListBinding? = null
    private val binding get() = _binding!!

    private val albumViewModel: AlbumViewModel by activityViewModels()
    private val albumAdapter = AlbumAdapter { album, _ ->
        requireActivity().supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                R.id.fragment_container_view,
                AlbumDetailFragment.newInstance(album.id),
            )
            addToBackStack(null)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentAlbumListBinding.inflate(inflater, container, false)
        setupObservers()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.albumRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = albumAdapter
        }
        albumViewModel.fillData()
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            albumViewModel.albums.collect { event ->
                when (event) {
                    AlbumViewModel.AlbumEvent.Failure -> {
                        binding.progressBar.isVisible = false
                        binding.albumRecyclerView.isVisible = false
                        binding.errorMessage.isVisible = true
                    }
                    AlbumViewModel.AlbumEvent.Loading -> {
                        binding.progressBar.isVisible = true
                        binding.albumRecyclerView.isVisible = false
                        binding.errorMessage.isVisible = false
                    }
                    is AlbumViewModel.AlbumEvent.Success -> {
                        albumAdapter.refreshData(event.albums)
                        binding.progressBar.isVisible = false
                        binding.errorMessage.isVisible = false
                        binding.albumRecyclerView.isVisible = true
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null;
    }
}
