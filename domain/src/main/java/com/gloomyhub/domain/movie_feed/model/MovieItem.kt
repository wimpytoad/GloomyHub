package com.gloomyhub.domain.movie_feed.model

import com.gloomyhub.domain.movie_feed.entity.Item

const val posterBaseUrl: String = "https://image.tmdb.org/t/p/w500"

data class MovieItem (
    val title: String,
    val description: String,
    val posterUrl: String,
    val genre: String,
    val author: String
) {
    companion object {
        fun map(item: Item) : MovieItem {
            return MovieItem(title = item.title,
            description = item.overview,
            posterUrl = posterBaseUrl.plus(item.poster_path),
            genre = item.genre_ids.toString(),
            author = "wtf")
        }

    }
}

