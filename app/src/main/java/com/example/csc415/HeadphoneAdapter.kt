package com.example.csc415

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HeadphoneAdapter(private val headphones: List<Headphone>) : RecyclerView.Adapter<HeadphoneAdapter.HeadphoneViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HeadphoneViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.headphone_card_view, parent, false)
    )

    override fun getItemCount() = headphones.size

    override fun onBindViewHolder(holder: HeadphoneViewHolder, position: Int) {
        val headphone = headphones[position]
        holder.headphoneImage.setImageResource(headphone.image)
        holder.headphoneName.text = headphone.name
        holder.headphoneBrand.text = headphone.brand
    }

    class HeadphoneViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val headphoneImage: ImageView = itemView.findViewById(R.id.headphone_image)
        val headphoneName: TextView = itemView.findViewById(R.id.headphone_name)
        val headphoneBrand: TextView = itemView.findViewById(R.id.headphone_brand)
    }

}