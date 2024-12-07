package com.irv205.rickmortygraphql.domain.model

data class Character(
    val id: String,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val image: String,
    val originName: String,
    val locationName: String
)