package com.example.csc415.data.model

import com.example.csc415.model.Album

sealed class MusicResponse {
    data class Success(val albums: List<Album>) : MusicResponse()
    object Error : MusicResponse()
}
