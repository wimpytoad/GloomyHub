package com.gloomyhub.data.response


import com.toadfrogson.gloomyhub.response.ErrorResponse
import kotlinx.serialization.Serializable

data class ApiResponse<T>(
    val success: Boolean = false,
    val data: T?,
    val errorResponse: ErrorResponse?
)

@Serializable
data class ApiResponseEmpty(
    val success: Boolean = false,
    val errorResponse: ErrorResponse? = null
)