package com.gloomyhub.domain.movie_feed

import com.gloomyhub.data.client.ApiType
import com.gloomyhub.data.client.WebClient
import com.gloomyhub.data.response.ApiResponse
import com.gloomyhub.domain.movie_feed.entity.MovieFeedEntity
import kotlin.time.ExperimentalTime

//TODO: hide api key
private const val horror_list = "3/list/8202584?api_key=8c241427387d1477f9214911ad446bbb&language=en-US"

interface MovieFeedApi {
    suspend fun getSuggestions(): ApiResponse<MovieFeedEntity>
}

class MovieFeedApiImpl constructor(private val client: WebClient) : MovieFeedApi
{
    @OptIn(ExperimentalTime::class)
    override suspend fun getSuggestions(): ApiResponse<MovieFeedEntity> {
        return client.makeClientGet<MovieFeedEntity>(horror_list, ApiType.MOVIE_BASE)
    }
}