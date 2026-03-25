package com.example.jc_interview.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.jc_interview.data.room.entity.SongEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SongDao{

    @Query("Select * from mysongs")
    fun fetchSongs() : Flow<List<SongEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSongs(songs: List<SongEntity>)

    @Query("UPDATE mysongs SET isFavourite = :isFav WHERE id = :id")
    suspend fun updateFavoriteStatus(id: Int, isFav: Boolean)

}