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
import org.example.rickmotryapp.domain.Repository


class CharactersViewModel(val getRandomCharacter: GetRandomCharacter, private val repository: Repository) : ViewModel() {

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
        getAllChacarters()
    }

    // funcion para obtener todos los personajes
    private fun getAllChacarters() {
        _state.update { it.copy(characters = repository.getAllCharacters()) } //actualizamos el estado de la pantalla con todos los personajes obtenidos
    }
}


