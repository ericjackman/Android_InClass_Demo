package com.example.csc415.data.repository

import com.example.csc415.data.model.MusicResponse

interface AlbumRepository {
    suspend fun getAlbums(): MusicResponse
}