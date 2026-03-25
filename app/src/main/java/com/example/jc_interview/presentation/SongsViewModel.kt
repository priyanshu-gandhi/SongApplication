package com.example.jc_interview.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jc_interview.domain.Repository
import com.example.jc_interview.domain.Song
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SongsViewModel @Inject constructor(private val repo : Repository): ViewModel() {
    private var _songsList = MutableStateFlow<List<Song>>(emptyList())
    val songsList: StateFlow<List<Song>> = repo.songsFlow
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    var isLoading : Boolean = false
    var isLastPage : Boolean = false
    var currentPage = 1


    init{
        loadSongs()
    }

    private fun loadSongs(){
        viewModelScope.launch {
            if(isLoading || isLastPage ) return@launch

            try {
                isLoading = true
                val response = repo.refreshSongs()
            } catch (e: Exception){

            }
            finally {
                isLoading = false
            }
        }
    }

    fun updateSong(songId: Int) {
        viewModelScope.launch {
            val song = songsList.value.find { it.id == songId }
            song?.let {
                repo.toggleFavorite(it.id, it.isFavourite)
            }
        }
    }
}