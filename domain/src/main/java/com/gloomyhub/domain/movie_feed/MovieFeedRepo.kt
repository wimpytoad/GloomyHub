package com.gloomyhub.domain.movie_feed

import com.gloomyhub.data.response.ApiResponse
import com.gloomyhub.data.response.ErrorResponse
import com.gloomyhub.domain.movie_feed.model.MovieItem

interface MovieFeedRepo {
    suspend fun getHorrorMovies(): ApiResponse<List<MovieItem>>
}

class MovieFeedRepoImpl constructor(private val api: MovieFeedApi) : MovieFeedRepo {
    override suspend fun getHorrorMovies(): ApiResponse<List<MovieItem>> {
        val result = api.getSuggestions()

        if (!result.success) {
            return ApiResponse(
                false,
                null,
                ErrorResponse("Could not get movies", 0)
            )
        }
        val transformedResult = mutableListOf<MovieItem>()

        result.data?.items?.forEach { item ->
            transformedResult.add(MovieItem.map(item))
        }

        return ApiResponse(true, transformedResult, null)
    }
}