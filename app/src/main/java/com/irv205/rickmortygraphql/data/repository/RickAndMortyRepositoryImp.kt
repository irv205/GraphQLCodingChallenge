package com.irv205.rickmortygraphql.data.repository

import com.apollographql.apollo3.ApolloClient
import com.irv205.rickmortygraphql.GetCharactersQuery
import com.irv205.rickmortygraphql.data.mapper.toDomain
import com.irv205.rickmortygraphql.domain.model.CharactersResponse
import com.irv205.rickmortygraphql.domain.repository.RickAndMortyRepository
import com.apollographql.apollo3.api.Optional
import com.irv205.rickmortygraphql.GetCharacterQuery
import com.irv205.rickmortygraphql.domain.model.Character
import javax.inject.Inject

class RickAndMortyRepositoryImp @Inject constructor(
    private val apolloClient: ApolloClient
): RickAndMortyRepository {

    override suspend fun getCharacters(page: Int): CharactersResponse {
        val response = apolloClient.query(GetCharactersQuery(page = Optional.Present(page))).execute()
        val data = response.data?.characters

        return CharactersResponse(
            info = data?.info?.toDomain() ?: throw IllegalStateException("No pagination info available"),
            characters = data.results?.mapNotNull { it?.toDomain() } ?: emptyList()
        )
    }

    override suspend fun getCharacterDetails(id: String): Character {
        val response = apolloClient.query(GetCharacterQuery(id = id)).execute()
        val character = response.data?.character
            ?: throw IllegalStateException("Character not found for ID: $id")

        return character.toDomain()
    }
}