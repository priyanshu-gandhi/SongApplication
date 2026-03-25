package com.example.jc_interview.data

import com.example.jc_interview.domain.Song
import retrofit2.http.GET
import retrofit2.http.Query

interface SongsInterfece{

    @GET("songs")
    suspend fun getSongs(@Query ("page") page: Int  ) : List<Song>
}