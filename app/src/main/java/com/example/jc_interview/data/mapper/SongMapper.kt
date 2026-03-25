package com.example.jc_interview.data.mapper

import com.example.jc_interview.data.room.entity.SongEntity
import com.example.jc_interview.domain.Song

fun SongEntity.toDomain(): Song {
    return Song(id, songName, songLength, isFavourite)
}

fun Song.toEntity(): SongEntity {
    return SongEntity(id, songName, songLength, isFavourite)
}