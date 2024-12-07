package com.irv205.rickmortygraphql.domain.usecase

import com.irv205.rickmortygraphql.domain.model.CharactersResponse
import com.irv205.rickmortygraphql.domain.repository.RickAndMortyRepository
import javax.inject.Inject


class GetCharactersUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {
    suspend operator fun invoke(page: Int): CharactersResponse {
        return repository.getCharacters(page)
    }
}