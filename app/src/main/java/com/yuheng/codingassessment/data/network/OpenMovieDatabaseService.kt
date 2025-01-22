package com.yuheng.codingassessment.data.network

import com.yuheng.codingassessment.domain.entities.OpenMovieDatabaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenMovieDatabaseService {

    @GET(".")
    suspend fun downloadMovies(
        @Query("s") movieTitle: String,
        @Query("apikey") apiKey: String,
    ): Response<OpenMovieDatabaseResponse>
}