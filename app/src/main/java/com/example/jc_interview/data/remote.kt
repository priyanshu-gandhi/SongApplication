package com.example.jc_interview.data

import com.example.jc_interview.domain.Song
import retrofit2.http.GET

interface SongsInterfece{

    @GET("songs")
    suspend fun getSongs() : List<Song>
}