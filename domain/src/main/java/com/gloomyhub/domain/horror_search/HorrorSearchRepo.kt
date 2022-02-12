package com.gloomyhub.domain.horror_search


import com.gloomyhub.data.response.ApiResponse
import com.gloomyhub.data.response.ErrorResponse
import com.gloomyhub.domain.horror_search.model.BookItem

interface HorrorSearchRepo {
    suspend fun getHorrorBooks(): ApiResponse<List<BookItem>>
}

class HorrorSearchRepoImpl constructor(private val api: HorrorSearchApi) : HorrorSearchRepo {
    override suspend fun getHorrorBooks(): ApiResponse<List<BookItem>> {
        val result = api.getSuggestions()
        if (!result.success) {
            return ApiResponse(false,
                null,
                ErrorResponse("Could not get books", 0))
        }
        val tranformedResult = mutableListOf<BookItem>()

        result.data?.items?.forEach { item ->
            tranformedResult.add(BookItem.map(item))
        }

        return ApiResponse(true, tranformedResult, null)
    }
}