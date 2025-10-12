package com.example.weatherkmp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.weatherkmp.di.appModule
import com.example.weatherkmp.ui.component.SimpleScaffold
import com.example.weatherkmp.ui.screen.HomeScreen
import com.example.weatherkmp.ui.theme.WeatherTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.dsl.KoinAppDeclaration

@Composable
@Preview
fun App() =
    WeatherTheme {
        KoinApplication(
            application = {
                modules(appModule)
            }
        ) {
            var showContent by remember { mutableStateOf(false) }
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primaryContainer)

                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                SimpleScaffold() { HomeScreen() }
            }

        }

    }
