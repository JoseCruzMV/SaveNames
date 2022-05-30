package com.example.savenames.domain.model

import com.example.savenames.data.database.entities.NameEntity

data class Name(
    val name: String,
)

fun NameEntity.toDomain(): Name = Name(name = name)