package org.example.dragonball.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    val homeViewModel : HomeViewModel = koinViewModel()


    val example by homeViewModel.example.collectAsState()

    Column {
        Text(text = example)
    }

}