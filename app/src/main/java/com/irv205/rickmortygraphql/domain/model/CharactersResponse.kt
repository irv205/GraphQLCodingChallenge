package com.irv205.rickmortygraphql.domain.model

data class CharactersResponse(
    val info: PaginationInfo,
    val characters: List<Character>
)