package com.gloomyhub.domain.horror_search


import com.gloomyhub.data.response.ApiResponse
import com.gloomyhub.data.response.ErrorResponse
import com.gloomyhub.domain.horror_search.entity.BookshelfEntity
import javax.inject.Inject

interface HorrorSearchRepo {
    suspend fun getHorrorBooks(): ApiResponse<BookshelfEntity>
}

class HorrorSearchRepoImpl @Inject constructor(private val api: HorrorSearchApi) : HorrorSearchRepo {
    override suspend fun getHorrorBooks(): ApiResponse<BookshelfEntity> {
        val result = api.getSuggestions()
        return if (result.success) result else ApiResponse(false,
            null,
            ErrorResponse("Could not get books", 0))
    }
}