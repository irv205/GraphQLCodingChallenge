package com.irv205.rickmortygraphql.domain.model

data class EpisodesResponse(
    val info: PaginationInfo,
    val episodes: List<Episode>
)