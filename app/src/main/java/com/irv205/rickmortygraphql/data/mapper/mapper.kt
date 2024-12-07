package com.irv205.rickmortygraphql.data.mapper

import com.irv205.rickmortygraphql.*
import com.irv205.rickmortygraphql.domain.model.*

fun GetCharactersQuery.Result.toDomain(): Character {
    val characterFields = this.characterFields
    return Character(
        id = characterFields.id.orEmpty(),
        name = characterFields.name.orEmpty(),
        status = characterFields.status.orEmpty(),
        species = characterFields.species.orEmpty(),
        gender = characterFields.gender.orEmpty(),
        image = characterFields.image.orEmpty(),
        originName = characterFields.origin?.originFields?.name.orEmpty(),
        locationName = characterFields.location?.locationFields?.name.orEmpty()
    )
}

fun GetCharacterQuery.Character.toDomain(): Character {
    val characterFields = this.characterFields
    return Character(
        id = characterFields.id.orEmpty(),
        name = characterFields.name.orEmpty(),
        status = characterFields.status.orEmpty(),
        species = characterFields.species.orEmpty(),
        gender = characterFields.gender.orEmpty(),
        image = characterFields.image.orEmpty(),
        originName = characterFields.origin?.originFields?.name.orEmpty(),
        locationName = characterFields.location?.locationFields?.name.orEmpty()
    )
}

fun GetCharactersQuery.Info.toDomain(): PaginationInfo {
    val infoFields = this.infoFields
    return PaginationInfo(
        totalCount = infoFields.count ?: 0,
        totalPages = infoFields.pages ?: 0,
    )
}