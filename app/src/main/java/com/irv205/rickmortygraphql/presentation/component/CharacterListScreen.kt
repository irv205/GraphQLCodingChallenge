package com.irv205.rickmortygraphql.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.irv205.rickmortygraphql.presentation.MainViewModel
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CharacterListScreen(
    viewModel: MainViewModel = hiltViewModel(),
    onCharacterClick: (String) -> Unit
) {
    val charactersState = viewModel.characters.collectAsState()
    val isLoading = viewModel.isLoading.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchCharacters()
    }

    val characters = charactersState.value?.characters ?: emptyList()

    CharacterList(
        characters = characters,
        isLoading = isLoading.value,
        onLoadMore = { viewModel.fetchCharacters() },
        onCharacterClick = onCharacterClick
    )
}