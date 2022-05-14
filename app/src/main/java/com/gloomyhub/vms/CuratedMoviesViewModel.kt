package com.gloomyhub.vms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.gloomyhub.domain.movie_feed.MovieFeedRepo
import com.gloomyhub.domain.movie_feed.model.MovieItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CuratedMoviesViewModel (private val repo: MovieFeedRepo) : ViewModel() {

    val suggestionsState = MutableStateFlow<List<MovieItem>>(emptyList())

    init {
        getSuggestions()
    }

    private fun getSuggestions() {
        viewModelScope.launch {
            val result = repo.getHorrorMovies()
            suggestionsState.emit(result.data.orEmpty())

        }
    }
}