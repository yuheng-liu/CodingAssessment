package com.yuheng.codingassessment.repos

import com.yuheng.codingassessment.models.Movie
import com.yuheng.codingassessment.network.RetrofitServiceBuilder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

private const val API_KEY = "8d6aa4ca"

object MovieRepository {

    private val _moviesInfo = MutableStateFlow(emptyList<Movie>())
    val movieInfo = _moviesInfo.asStateFlow()

    private val openMovieDatabaseService = RetrofitServiceBuilder().getOpenMoviesDatabaseService()

    suspend fun getMoviesFromTitle(title: String) {
        val response = openMovieDatabaseService.downloadMovies(title, API_KEY)
        if (response.isSuccessful) {
            response.body()?.let { body ->
                _moviesInfo.value = body.Search
            }
        } else {
            response.errorBody()?.let { error ->
                println("MovieRepository Error: ${error.string()}")
            }
        }
    }
}