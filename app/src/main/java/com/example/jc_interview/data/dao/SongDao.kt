package com.example.jc_interview.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.jc_interview.domain.Song

@Dao
interface SongDao{

    @Query("Select * from mysongs")
    fun fetchSongs() : List<Song>
}