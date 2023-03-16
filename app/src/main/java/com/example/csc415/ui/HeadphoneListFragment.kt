package com.example.csc415.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.csc415.model.Headphone
import com.example.csc415.ui.adapter.HeadphoneAdapter
import com.example.csc415.R
import com.example.csc415.ViewModel.HeadphoneViewModel
import com.example.csc415.databinding.FragmentHeadphoneListBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class HeadphoneListFragment : Fragment() {

    private val headphoneViewModel: HeadphoneViewModel by viewModels()
    private var _binding: FragmentHeadphoneListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHeadphoneListBinding.inflate(inflater, container, false)
        binding.headphoneRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        val headphones = headphoneViewModel.fillData()
        val adapter = HeadphoneAdapter(headphones) { position ->
            val headphone = headphones[position]

            requireActivity().supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, HeadphoneDetailFragment.newInstance(headphone.id))
                addToBackStack(null)
            }
        }

        binding.headphoneRecyclerView.adapter = adapter
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null;
    }
}
