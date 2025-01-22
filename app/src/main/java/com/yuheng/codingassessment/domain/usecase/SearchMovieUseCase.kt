package com.yuheng.codingassessment.domain.usecase

import com.yuheng.codingassessment.domain.MovieRepository
import javax.inject.Inject

class SearchMovieUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    suspend operator fun invoke(movieTitle: String) {
        movieRepository.getMoviesFromTitle(movieTitle)
    }
}