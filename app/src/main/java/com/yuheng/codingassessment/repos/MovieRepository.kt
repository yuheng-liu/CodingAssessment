package com.yuheng.codingassessment.repos

import com.yuheng.codingassessment.models.Movie
import kotlinx.coroutines.flow.StateFlow

interface MovieRepository {

    fun getMovieInfo(): StateFlow<List<Movie>>

    suspend fun getMoviesFromTitle(title: String)
}