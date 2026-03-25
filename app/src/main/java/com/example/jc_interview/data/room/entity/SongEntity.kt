package com.example.jc_interview.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mysongs")
data class SongEntity(
    @PrimaryKey
    val id: Int,
    val songName : String,
    val songLength : String,
    val isFavourite : Boolean
)