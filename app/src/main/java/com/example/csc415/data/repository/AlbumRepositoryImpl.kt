package com.example.csc415.data.repository

import android.util.Log
import com.example.csc415.data.MusicAPI
import com.example.csc415.data.model.MusicResponse
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(
    private val musicAPI: MusicAPI,
) : AlbumRepository {
    override suspend fun getAlbums(): MusicResponse {
        val result = musicAPI.getAlbums()
        Log.v("Eric", result.body().toString())
        return if (result.isSuccessful) {
            MusicResponse.Success(result.body()?.albums ?: emptyList())
        } else {
            MusicResponse.Error
        }
    }
}