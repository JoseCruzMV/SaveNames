package com.example.savenames.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.savenames.data.database.entities.NameEntity

@Dao
interface NameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertName(name: NameEntity)

    @Query("SELECT * FROM name_table")
    suspend fun getAllNames(): List<NameEntity>
}