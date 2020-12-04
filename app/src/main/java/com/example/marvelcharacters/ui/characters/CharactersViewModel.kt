package com.example.marvelcharacters.ui.characters

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.marvelcharacters.repository.MarvelRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
class CharactersViewModel @ViewModelInject constructor(
    private val characterRepository: MarvelRepository
) : ViewModel() {

    val character = Pager(PagingConfig(pageSize = 1,enablePlaceholders = true)) {
        characterRepository
    }.flow.cachedIn(viewModelScope)


}