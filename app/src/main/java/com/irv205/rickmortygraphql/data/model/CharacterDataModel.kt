package com.irv205.rickmortygraphql.data.model

data class CharacterDataModel(
    val id: String,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: LocationDataModel,
    val location: LocationDataModel,
    val image: String,
    val created: String
)