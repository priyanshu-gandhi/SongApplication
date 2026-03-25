package com.example.jc_interview.domain

import com.example.jc_interview.data.SongsInterfece
import com.example.jc_interview.data.mapper.toDomain
import com.example.jc_interview.data.mapper.toEntity
import com.example.jc_interview.data.room.dao.SongDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class Repository @Inject constructor(private val apiService : SongsInterfece,
    private val songDao : SongDao){

    val songsFlow: Flow<List<Song>> =
        songDao.fetchSongs().map { list ->
            list.map { it.toDomain() }
        }

    suspend fun refreshSongs() {
        val networkSongs = apiService.getSongs()

        songDao.insertSongs(
            networkSongs.map { it.toEntity() }
        )
    }

    suspend fun toggleFavorite(songId: Int, currentStatus: Boolean) {
        songDao.updateFavoriteStatus(songId, !currentStatus)
    }
}