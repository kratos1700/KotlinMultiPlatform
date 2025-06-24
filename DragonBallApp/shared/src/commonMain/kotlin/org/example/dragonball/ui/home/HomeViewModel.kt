package org.example.dragonball.ui.home

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.MutableStateFlow
import com.rickclephas.kmp.observableviewmodel.ViewModel
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(): ViewModel() {

    private val _example = MutableStateFlow<String>(viewModelScope,"Hello from HomeViewModel")
    @NativeCoroutinesState
    val example :StateFlow<String> = _example

}