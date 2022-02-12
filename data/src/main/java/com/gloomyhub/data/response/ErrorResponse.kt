package com.gloomyhub.data.response

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    var message: String,
    val code: Int
)