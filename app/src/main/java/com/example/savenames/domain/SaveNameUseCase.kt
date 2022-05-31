package com.example.savenames.domain

import com.example.savenames.data.NameRepository
import com.example.savenames.domain.model.Name
import javax.inject.Inject

class SaveNameUseCase @Inject constructor(
    private val repository: NameRepository
) {
    suspend operator fun invoke(query: String) =
        repository.insertName(Name(name = query))
}