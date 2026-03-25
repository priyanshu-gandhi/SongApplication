package com.example.jc_interview.data.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jc_interview.data.room.dao.SongDao
import com.example.jc_interview.data.room.entity.SongEntity

@Database(entities = [SongEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun songDao(): SongDao
}