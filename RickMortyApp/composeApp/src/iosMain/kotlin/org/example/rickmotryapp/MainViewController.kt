package org.example.rickmotryapp

import androidx.compose.ui.window.ComposeUIViewController
import org.example.rickmotryapp.di.initKoin

//afegim  al ComposeUIViewController el initKoin, posem  (configure = { initKoin()} ) per a que s'inicialitzi el Koin

fun MainViewController() = ComposeUIViewController(configure = { initKoin()} ) { App() }