package com.gloomyhub.vms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gloomyhub.domain.horror_search.HorrorSearchRepo
import com.gloomyhub.domain.horror_search.model.BookItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CuratedSectionViewModel (private val repo: HorrorSearchRepo) : ViewModel() {

    val suggestionsState = MutableStateFlow<List<BookItem>>(emptyList())

    init {
        getSuggestions()
    }

    private fun getSuggestions() {
        viewModelScope.launch {
            val result = repo.getHorrorBooks()
            suggestionsState.emit(result.data.orEmpty())

        }
    }
}