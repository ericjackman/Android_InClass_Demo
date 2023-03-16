package com.example.csc415.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.csc415.model.Headphone
import com.example.csc415.databinding.HeadphoneCardViewBinding


class HeadphoneAdapter(
    private val headphones: List<Headphone>,
    private val onItemClick: (adapterPosition: Int) -> Unit
) :
    RecyclerView.Adapter<HeadphoneAdapter.HeadphoneViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadphoneViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HeadphoneCardViewBinding.inflate(layoutInflater, parent, false)

        return HeadphoneViewHolder(binding) { position ->
            onItemClick(position)
        }
    }

    override fun getItemCount() = headphones.size

    override fun onBindViewHolder(holder: HeadphoneViewHolder, position: Int) {
        val headphone = headphones[position]
        holder.bind(headphone)
    }

    inner class HeadphoneViewHolder(
        private val binding: HeadphoneCardViewBinding,
        private val onItemClick: (adapterPosition: Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

        fun bind(headphone: Headphone) {
            Glide
                .with(binding.root)
                .load(headphone.image)
                .into(binding.headphoneImage)
            binding.headphoneName.text = headphone.name
            binding.headphoneBrand.text = headphone.brand
        }
    }

}
