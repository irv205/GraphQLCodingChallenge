package com.irv205.rickmortygraphql.data.model

data class EpisodeDataModel(
    val id: String,
    val name: String,
    val airDate: String,
    val episode: String,
    val characters: List<String>,
    val created: String
)