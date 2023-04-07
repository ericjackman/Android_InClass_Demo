package com.example.csc415.ui.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.csc415.R
import com.example.csc415.databinding.AlbumCardViewBinding
import com.example.csc415.model.Album


class AlbumAdapter(
    private val onItemClick: (album: Album, adapterPosition: Int) -> Unit,
) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    init {
        setHasStableIds(true)
    }

    private val albums = mutableListOf<Album>()

    @SuppressLint("NotifyDataSetChanged")
    fun refreshData(albumsList: List<Album>) {
        albums.clear()
        albums.addAll(albumsList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = AlbumCardViewBinding.inflate(layoutInflater, parent, false)
        return AlbumViewHolder(binding) { position ->
            onItemClick(albums[position], position)
        }
    }

    override fun getItemCount() = albums.size

    override fun getItemId(position: Int) = position.toLong()

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = albums[position]
        holder.bind(album)
    }

    inner class AlbumViewHolder(
        private val binding: AlbumCardViewBinding,
        private val onItemClick: (adapterPosition: Int) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

        fun bind(album: Album) {
            Glide
                .with(binding.root)
                .load(album.basicInformation.coverImage)
                //.error(R.drawable.baseline_10k_24)  // TODO
                .into(binding.albumCover)

            binding.albumTitle.text = album.basicInformation.title
            binding.albumArtist.text = album.basicInformation.artists[0].name
        }
    }
}
