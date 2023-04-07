package com.example.csc415.data

import com.example.csc415.model.AlbumResponse
import retrofit2.Response
import retrofit2.http.GET

interface MusicAPI {
    @GET(value = "/users/EricJackman/wants")
    suspend fun getAlbums() : Response<AlbumResponse>
}