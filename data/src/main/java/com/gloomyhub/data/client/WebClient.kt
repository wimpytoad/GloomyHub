package com.gloomyhub.data.client

import com.gloomyhub.data.response.ApiResponse
import com.gloomyhub.data.response.ErrorResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.client.engine.cio.*
import io.ktor.http.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlin.time.ExperimentalTime


class WebClientException(val statusCode: HttpStatusCode) : Exception()

class WebClient{

    @ExperimentalTime
    suspend inline fun <reified T : Any> makeClientGet(endpoint: String, apiType: ApiType): ApiResponse<T> {

        val url = when (apiType) {
            ApiType.GOOGLE_BOOKS -> BaseUrls.googleBooksBaseUrl + endpoint
            ApiType.MOVIE_BASE -> BaseUrls.movieBaseUrl + endpoint
        }

        try {
            val client = getClient() {
                throw WebClientException(it)
            }
            val response =  client.use {
                it.get<T>(url)
            }

            println("GET '$url' SUCCESS")
            return ApiResponse(true, response, null)
        } catch (ex: Exception) {
            return when (ex) {
                is WebClientException -> ApiResponse(false, null,
                    ErrorResponse("", ex.statusCode.value))
                is NoTransformationFoundException, is Exception-> {
                    println("GET '$url' FAILED: '${ex.message}'")
                    ApiResponse(true, null, null)
                }
                else -> ApiResponse(false, null, null)
            }
        }
    }

    @ExperimentalTime
    @ExperimentalSerializationApi
    @PublishedApi
    internal fun getClient(httpResponse: (HttpStatusCode) -> Unit): HttpClient {
        return HttpClient(CIO) {

            install(HttpTimeout) {
                requestTimeoutMillis = 6000
            }

            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    ignoreUnknownKeys = true
                    explicitNulls = false
                })
            }


            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
            HttpResponseValidator {
                handleResponseException { exception ->
                    val exceptionResponse = (exception as? ClientRequestException)?.response

                    exceptionResponse?.status?.let { statusCode ->
                        httpResponse(statusCode)
                    }
                }
            }
        }

    }
}