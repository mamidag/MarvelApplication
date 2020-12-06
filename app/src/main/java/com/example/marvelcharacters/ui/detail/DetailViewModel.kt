package com.example.marvelcharacters.ui.detail

import android.content.Context
import android.widget.Toast
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.lifecycle.MutableLiveData
import com.example.marvelcharacters.api.model.Marvel
import com.example.marvelcharacters.api.model.data.result.Result
import com.example.marvelcharacters.dataresource.Resource
import com.example.marvelcharacters.listener.IListener
import com.example.marvelcharacters.repository.CharactersRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@ExperimentalCoroutinesApi
class DetailViewModel @ViewModelInject constructor(
    private val charactersRepository: CharactersRepository
) : ViewModel() {

    val characterDetails: MutableLiveData<Resource<Marvel>> = MutableLiveData()

    fun getCharacterDetails(characterId: Int): LiveData<Resource<Marvel>> {
        return if (characterDetails.value?.data == null) {
            viewModelScope.launch {
                charactersRepository.fetchCharacterDetail(characterId).collect {
                    characterDetails.postValue(it)
                }
            }
            characterDetails
        } else {
            characterDetails
        }

    }

}