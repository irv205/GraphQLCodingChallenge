package com.irv205.rickmortygraphql.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.irv205.rickmortygraphql.presentation.component.CharacterList
import com.irv205.rickmortygraphql.presentation.component.CharacterListScreen
import com.irv205.rickmortygraphql.presentation.navigation.NavGraph
import com.irv205.rickmortygraphql.presentation.ui.theme.RickMortyGraphQLTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickMortyGraphQLTheme {
                NavGraph()
            }
        }
    }
}