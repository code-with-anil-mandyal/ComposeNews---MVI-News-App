package com.mviktorcomposeexample.data.remote.api

import com.mviktorcomposeexample.data.remote.api.ApiKeys.BASE_URL
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.URLBuilder

open class BaseApiService(
     val httpClient: HttpClient
) {
    protected suspend inline fun <reified T> getRequest(
        endpoint: String,
        queryParams: Map<String, String> = emptyMap()
    ): T {
        val urlBuilder = URLBuilder("$BASE_URL$endpoint").apply {
            parameters.append("apiKey", ApiKeys.API_KEY)
            queryParams.forEach { (key, value) ->
                parameters.append(key, value)
            }
        }

        val finalUrl = urlBuilder.buildString()
        println("Final API URL: $finalUrl")  // 👈 this will log complete url

        return httpClient.get(finalUrl).body()
    }


}