package com.arafat1419.core.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arafat1419.core.data.local.entity.ExampleEntity

@Database(
    entities = [ExampleEntity::class],
    version = 1,
    exportSchema = false
)
internal abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao
}