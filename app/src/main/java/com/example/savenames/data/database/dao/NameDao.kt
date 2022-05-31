package com.example.savenames.data.database.dao

import androidx.room.*
import com.example.savenames.data.database.entities.NameEntity

@Dao
interface NameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertName(name: NameEntity)

    @Query("SELECT * FROM name_table")
    suspend fun getAllNames(): List<NameEntity>

    @Query("DELETE FROM name_table WHERE id = :name")
    suspend fun deleteName(name: Int)
}