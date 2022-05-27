package com.example.savenames.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.savenames.data.database.entities.NameEntity

@Database(entities = [NameEntity::class], version = 1)
abstract class NameDatabase : RoomDatabase()