package com.example.csc415.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import com.example.csc415.viewModel.AlbumViewModel
import com.example.csc415.databinding.FragmentAlbumDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumDetailFragment : Fragment() {

    private val albumViewModel: AlbumViewModel by activityViewModels()
    private var _binding: FragmentAlbumDetailBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlbumDetailBinding.inflate(inflater, container, false)
//        val album = albumViewModel.fetchByID(requireArguments().getInt(BUNDLE_ID))
//
//        Glide
//            .with(this)
//            .load(album.cover)
//            .into(binding.albumDetailCover)
//        binding.albumDetailTitle.text = album.title
//        binding.albumDetailArtist.text = album.artist
//        binding.albumDetailRelease.text = "Album - ${album.releaseYear}"
//        binding.albumDetailGenre.text = "Genre: ${album.genre}"
//
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val BUNDLE_ID = "id"

        fun newInstance(id: Int): AlbumDetailFragment {
            val detailFragment = AlbumDetailFragment()
            detailFragment.arguments = bundleOf(BUNDLE_ID to id)
            return detailFragment
        }
    }
}