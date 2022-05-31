package com.example.savenames.domain.model

import com.example.savenames.data.database.entities.NameEntity

data class Name(
    val id: Int? = null,
    val name: String,
)

fun NameEntity.toDomain(): Name = Name(id = id, name = name)