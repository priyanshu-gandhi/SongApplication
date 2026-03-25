package com.example.jc_interview.data

import androidx.room.Entity

@Entity(tableName = "Mysongs")
data class Song(
    val id: Int,
    val songName : String,
    val songLength : String,
    val isFavourite : Boolean
)