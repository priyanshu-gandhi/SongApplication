package com.example.jc_interview.presentation

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jc_interview.domain.Repository
import com.example.jc_interview.domain.Song
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class SongsViewModel @Inject constructor(private val repo : Repository): ViewModel() {

    val songList = listOf(Song(1,"a", "2",true),
        Song(12,"ab", "4",false))
    private var _songsList = MutableStateFlow<List<Song>>(emptyList())
    var songsList : StateFlow<List<Song>> = _songsList.asStateFlow()

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
                val response = repo.loadSongs()
                if (response == null) {
                    isLastPage = true
                } else {
                    _songsList = _songsList + response
                }
            } catch (e: Exception){

            }
            finally {
                isLoading = false
            }
        }
    }

    fun updateSong(songId : Int){
         viewModelScope.launch {
             songsList.map{
                 if(songId == it.id){
                     it.copy(isFav = if(isFav) false else true )
                 }
             }
         }
    }



}