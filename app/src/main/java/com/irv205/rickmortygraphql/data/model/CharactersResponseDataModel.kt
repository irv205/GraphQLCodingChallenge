package com.irv205.rickmortygraphql.data.model

data class CharactersResponseDataModel(
    val info: PaginationInfoDataModel,
    val results: List<CharacterDataModel>
)

data class PaginationInfoDataModel(
    val count: Int,
    val pages: Int,
    val next: Int?,
    val prev: Int?
)