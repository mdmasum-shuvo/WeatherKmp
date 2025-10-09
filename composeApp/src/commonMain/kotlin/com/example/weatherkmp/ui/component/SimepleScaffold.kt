package com.example.weatherkmp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SimpleScaffold(
    topBar: @Composable (() -> Unit)? = null,
    bottomBar: @Composable (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize().background(
            brush = gradientColor()
        )
    ) {
        Column(Modifier.fillMaxSize()) {
            topBar?.invoke()
            Box(Modifier.weight(1f)) {
                content()
            }
            bottomBar?.invoke()
        }

    }
}