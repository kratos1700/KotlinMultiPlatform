package org.example.rickmotryapp.ui.home.tabs.characters

import androidx.lifecycle.ViewModel
import org.example.rickmotryapp.domain.GetRandomCharacter
import org.example.rickmotryapp.domain.model.CharacterModel


import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO



class CharactersViewModel(val getRandomCharacter: GetRandomCharacter) : ViewModel() {

    // para manejar el estado de la pantalla
    private val _state = MutableStateFlow<CharactersState>(CharactersState())
    val state: StateFlow<CharactersState> = _state


    init {  //se ejecuta al instanciar el viewmodel y se encarga de obtener un personaje aleatorio
        viewModelScope.launch {
            val result: CharacterModel = withContext(Dispatchers.IO) {
                getRandomCharacter()
            }
            _state.update { it.copy(characterOfTheDay = result) }  //actualizamos el estado de la pantalla con el personaje obtenido
        }
    }
}


