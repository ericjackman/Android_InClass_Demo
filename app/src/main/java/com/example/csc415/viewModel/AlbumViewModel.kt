package com.example.csc415.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.csc415.data.model.MusicResponse
import com.example.csc415.data.repository.AlbumRepository
import com.example.csc415.model.Album
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(
    private val albumRepository: AlbumRepository,
) : ViewModel() {

    private val _albums =
        MutableStateFlow<AlbumEvent>(AlbumEvent.Loading)
    val albums: StateFlow<AlbumEvent> = _albums

    fun fillData() {
        viewModelScope.launch {
            when (val response = albumRepository.getAlbums()) {
                MusicResponse.Error -> _albums.value = AlbumEvent.Failure
                is MusicResponse.Success -> _albums.value =
                    AlbumEvent.Success(response.albums)
            }
        }
    }

    sealed class AlbumEvent {
        data class Success(val albums: List<Album>) :
            AlbumEvent()
        object Failure : AlbumEvent()
        object Loading : AlbumEvent()
    }
}