package com.irv205.rickmortygraphql.presentation.navigation

sealed class Navigation(val route: String) {
    object HomeView : Navigation("characterList") // Ruta para la pantalla de lista de personajes
    object DetailView : Navigation("characterDetail/{characterId}") {
        fun createRoute(characterId: String) = "characterDetail/$characterId" // Generador de rutas dinámicas
    }
}