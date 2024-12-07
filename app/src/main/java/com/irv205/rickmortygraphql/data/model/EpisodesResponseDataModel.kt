package com.irv205.rickmortygraphql.data.model

data class EpisodesResponseDataModel(
    val info: PaginationInfoDataModel,
    val results: List<EpisodeDataModel>
)