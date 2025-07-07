package org.example.dragonball.ui.detail

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.MutableStateFlow
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import org.example.dragonball.domain.Repository
import org.example.dragonball.domain.model.CharacterDetailModel

class DetailViewModel (private val id:Int, private val repository: Repository) : ViewModel() {

    private val _character = MutableStateFlow<CharacterDetailModel?>(viewModelScope, null)
    @NativeCoroutinesState
    val character:StateFlow<CharacterDetailModel?> = _character

    init {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) { repository.getSingleCharacter(id) }
            if(response != null){
                _character.value = response
            }
        }
    }


}