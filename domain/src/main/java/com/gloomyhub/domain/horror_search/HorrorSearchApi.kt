package com.gloomyhub.domain.horror_search

import com.gloomyhub.data.client.ApiType
import com.gloomyhub.data.client.WebClient
import com.gloomyhub.data.response.ApiResponse
import com.gloomyhub.domain.horror_search.entity.BookshelfEntity
import kotlin.time.ExperimentalTime

private const val starred_bookshelf = "/users/101339306000599374173/bookshelves/0/volumes"

interface HorrorSearchApi {
    suspend fun getSuggestions(): ApiResponse<BookshelfEntity>
}

@ExperimentalTime
class HorrorSearchApiImpl constructor(private val client: WebClient) : HorrorSearchApi {
    override suspend fun getSuggestions(): ApiResponse<BookshelfEntity> {
        return client.makeClientGet(starred_bookshelf, ApiType.GOOGLE_BOOKS)
    }
}