package com.irv205.rickmortygraphql.domain.usecase

import com.irv205.rickmortygraphql.domain.model.Character
import com.irv205.rickmortygraphql.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class GetCharacterDetailsUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {
    suspend operator fun invoke(id: String): Character {
        return repository.getCharacterDetails(id)
    }
}