package org.example.rickmotryapp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.example.rickmotryapp.ui.core.navigation.NavigationWrapper
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        NavigationWrapper()
    }
}