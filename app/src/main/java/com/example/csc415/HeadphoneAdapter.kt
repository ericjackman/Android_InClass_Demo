package com.example.csc415

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.csc415.ui.HeadphoneDetailFragment

class HeadphoneAdapter(private val headphones: List<Headphone>) :
    RecyclerView.Adapter<HeadphoneAdapter.HeadphoneViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadphoneViewHolder {
        // view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.headphone_card_view, parent, false)

        // on-click logic
        return HeadphoneViewHolder(view) { position ->
            val headphone = headphones[position]

            val bundle = bundleOf(
                "name" to headphone.name,
                "brand" to headphone.brand,
                "image" to headphone.image,
                "price" to headphone.price,
                "weight" to headphone.weight,
                "driver" to headphone.driverType,
                "impedance" to headphone.impedance,
                "sensitivity" to headphone.sensitivity
            )

            val detailFragment = HeadphoneDetailFragment()
            detailFragment.arguments = bundle

            val activity = view.context as AppCompatActivity
            activity.supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, detailFragment)
                addToBackStack(null)
            }
        }
    }

    override fun getItemCount() = headphones.size

    override fun onBindViewHolder(holder: HeadphoneViewHolder, position: Int) {
        val headphone = headphones[position]
//        Glide
//            .with(holder.itemView.context)
//            .load(headphone.image)
//            .into(holder.headphoneImage)
        holder.headphoneImage.setImageResource(headphone.image)
        holder.headphoneName.text = headphone.name
        holder.headphoneBrand.text = headphone.brand
    }

    inner class HeadphoneViewHolder(
        itemView: View,
        private val onItemClick: (adapterPosition: Int) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        val headphoneImage: ImageView = itemView.findViewById(R.id.headphone_image)
        val headphoneName: TextView = itemView.findViewById(R.id.headphone_name)
        val headphoneBrand: TextView = itemView.findViewById(R.id.headphone_brand)

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }
    }

}