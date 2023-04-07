package com.example.csc415.di

import com.example.csc415.data.repository.AlbumRepository
import com.example.csc415.data.repository.AlbumRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAlbumRepository(
        albumRepositoryImpl: AlbumRepositoryImpl,
    ): AlbumRepository
}