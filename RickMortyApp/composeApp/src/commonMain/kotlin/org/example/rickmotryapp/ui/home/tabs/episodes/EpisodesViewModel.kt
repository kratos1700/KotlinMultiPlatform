package org.example.rickmotryapp.ui.home.tabs.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.example.rickmotryapp.domain.Repository

class EpisodesViewModel(private val repository: Repository) : ViewModel() {

    private val _state = MutableStateFlow<EpisodesState>(EpisodesState())
    val state: StateFlow<EpisodesState> = _state


    init {
        _state.update { it.copy(characters = repository.getAllEpisodes().cachedIn(viewModelScope)) }
    }

    fun playVideo(url: String) {
        _state.update { it.copy(playVideo = url) }
    }

    fun closeVideo() {
        _state.update { it.copy(playVideo = "") }
    }
}