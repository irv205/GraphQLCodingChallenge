package com.irv205.rickmortygraphql.domain.repository

import com.irv205.rickmortygraphql.domain.model.Character
import com.irv205.rickmortygraphql.domain.model.CharactersResponse

interface RickAndMortyRepository {
    suspend fun getCharacters(page: Int): CharactersResponse
    suspend fun getCharacterDetails(id: String): Character
}