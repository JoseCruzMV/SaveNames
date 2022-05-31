package com.example.savenames.data

import com.example.savenames.data.database.dao.NameDao
import com.example.savenames.data.database.entities.NameEntity
import com.example.savenames.data.database.entities.toDataBase
import com.example.savenames.domain.model.Name
import com.example.savenames.domain.model.toDomain
import javax.inject.Inject

class NameRepository @Inject constructor(
    private val nameDao: NameDao
) {
    suspend fun insertName(name: Name) =
        nameDao.insertName(name.toDataBase())

    suspend fun getAllNames(): List<Name> =
        nameDao.getAllNames().map { it.toDomain() }

    suspend fun deleteName(query: Name) =
        nameDao.deleteName(query.name)
}