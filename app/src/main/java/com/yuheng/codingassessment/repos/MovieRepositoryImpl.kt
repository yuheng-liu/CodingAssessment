package com.yuheng.codingassessment.repos

import com.yuheng.codingassessment.models.Movie
import com.yuheng.codingassessment.network.OpenMovieDatabaseService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

private const val API_KEY = "8d6aa4ca"

class MovieRepositoryImpl @Inject constructor(
    private val openMovieDatabaseService: OpenMovieDatabaseService,
): MovieRepository {

    private val _moviesInfo = MutableStateFlow(emptyList<Movie>())
    override fun getMovieInfo(): StateFlow<List<Movie>> = _moviesInfo.asStateFlow()

    override suspend fun getMoviesFromTitle(title: String) {
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