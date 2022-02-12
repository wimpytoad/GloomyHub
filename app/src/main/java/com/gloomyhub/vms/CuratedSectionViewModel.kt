package com.gloomyhub.vms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gloomyhub.domain.horror_search.HorrorSearchRepo
import com.gloomyhub.domain.horror_search.model.BookItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CuratedSectionViewModel @Inject constructor(private val repo: HorrorSearchRepo) : ViewModel() {
    val suggestionsState = MutableStateFlow<List<BookItem>>(emptyList())

    fun getSuggestions() {
        viewModelScope.launch {
            val result = repo.getHorrorBooks()
            suggestionsState.value = result.data ?: emptyList()
        }
    }
}