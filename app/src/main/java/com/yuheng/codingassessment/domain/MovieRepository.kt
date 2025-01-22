package com.yuheng.codingassessment.domain

import com.yuheng.codingassessment.domain.entities.Movie
import kotlinx.coroutines.flow.StateFlow

interface MovieRepository {

    fun getMovieInfo(): StateFlow<List<Movie>>

    suspend fun getMoviesFromTitle(title: String)
}