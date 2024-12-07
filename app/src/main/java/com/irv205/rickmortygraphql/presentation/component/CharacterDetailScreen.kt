package com.irv205.rickmortygraphql.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.irv205.rickmortygraphql.presentation.MainViewModel

@Composable
fun CharacterDetailScreen(
    characterId: String?,
    viewModel: MainViewModel = hiltViewModel()
) {
    // Observar el estado de los detalles del personaje
    val characterDetailsState = viewModel.characterDetails.collectAsState()

    LaunchedEffect(characterId) {
        if (characterId != null) {
            viewModel.fetchCharacterDetails(characterId) // Cargar los detalles del personaje
        }
    }

    val character = characterDetailsState.value

    if (character == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        CharacterDetailContent(character = character)
    }
}