package com.irv205.rickmortygraphql.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irv205.rickmortygraphql.domain.model.CharactersResponse
import com.irv205.rickmortygraphql.domain.usecase.GetCharacterDetailsUseCase
import com.irv205.rickmortygraphql.domain.usecase.GetCharactersUseCase
import com.irv205.rickmortygraphql.domain.model.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val getCharacterDetailsUseCase: GetCharacterDetailsUseCase
): ViewModel() {

    private val _characters = MutableStateFlow<CharactersResponse?>(null)
    val characters: StateFlow<CharactersResponse?> = _characters

    private val _characterDetails = MutableStateFlow<Character?>(null)
    val characterDetails: StateFlow<Character?> = _characterDetails

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private var currentPage = 1
    private var totalPages = 30

    fun fetchCharacters() {
        if (_isLoading.value || currentPage > totalPages) return

        _isLoading.value = true
        viewModelScope.launch {
            try {
                val response = getCharactersUseCase(currentPage)

                totalPages = response.info.totalPages

                val currentCharacters = _characters.value?.characters ?: emptyList()

                val updatedCharacters = currentCharacters.toMutableList()
                updatedCharacters.addAll(response.characters)

                _characters.value = CharactersResponse(
                    info = response.info,
                    characters = updatedCharacters
                )
                Log.e("List", characters.value?.characters.toString())

                currentPage++
            } catch (e: Exception) {
                println("Error fetching characters: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun fetchCharacterDetails(id: String) {
        viewModelScope.launch {
            try {
                val character = getCharacterDetailsUseCase(id)
                _characterDetails.value = character
            } catch (e: Exception) {
                println("Error fetching character details: ${e.message}")
            }
        }
    }
}