package org.example.dragonball

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import dragonballapp.composeapp.generated.resources.Res
import dragonballapp.composeapp.generated.resources.compose_multiplatform
import org.example.dragonball.core.navigation.NavigationWrapper
import org.example.dragonball.ui.home.HomeScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column(
            modifier = Modifier
               // .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
          NavigationWrapper()
        }
    }
}