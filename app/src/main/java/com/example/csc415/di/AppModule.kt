package com.example.csc415.di

import com.example.csc415.data.MusicAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesRickAndMortyApi(): MusicAPI =
        Retrofit.Builder()
            .baseUrl("https://api.discogs.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
}