package com.example.csc415.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.csc415.R
import com.example.csc415.ViewModel.HeadphoneViewModel
import com.example.csc415.databinding.FragmentHeadphoneDetailBinding
import com.example.csc415.databinding.FragmentHeadphoneListBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class HeadphoneDetailFragment : Fragment() {

    private val headphoneViewModel: HeadphoneViewModel by viewModels()
    private var _binding: FragmentHeadphoneDetailBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHeadphoneDetailBinding.inflate(inflater, container, false)
        val headphone = headphoneViewModel.fetchByID(requireArguments().getInt(BUNDLE_ID))

        Glide
            .with(this)
            .load(headphone.image)
            .into(binding.headphoneDetailImage)
        binding.headphoneDetailName.text = "${headphone.brand} ${headphone.name}"
        binding.headphoneDetailPrice.text = "Price: \$${headphone.price}"
        binding.headphoneDetailWeight.text = "Weight: ${headphone.weight} grams"
        binding.headphoneDetailDriver.text = "Driver Type: ${headphone.driverType}"
        binding.headphoneDetailImp.text = "Impedance: ${headphone.impedance} ohms"
        binding.headphoneDetailSens.text = "Sensitivity: ${headphone.sensitivity} dB"

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val BUNDLE_ID = "id"

        fun newInstance(id: Int): HeadphoneDetailFragment {
            val detailFragment = HeadphoneDetailFragment()
            detailFragment.arguments = bundleOf(BUNDLE_ID to id)
            return detailFragment
        }
    }
}