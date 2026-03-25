package com.example.jc_interview.domain

import com.example.jc_interview.data.SongsInterfece
import javax.inject.Inject

class Repository @Inject constructor(private val apiService : SongsInterfece ){

    suspend fun loadSongs() : List<Song>{
        return apiService.getSongs()
    }
}