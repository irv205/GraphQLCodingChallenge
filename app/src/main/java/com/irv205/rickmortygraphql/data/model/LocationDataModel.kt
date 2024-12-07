package com.irv205.rickmortygraphql.data.model

data class LocationDataModel(
    val id: String,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>
)