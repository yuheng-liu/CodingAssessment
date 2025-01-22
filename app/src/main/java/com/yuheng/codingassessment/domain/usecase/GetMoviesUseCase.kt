package com.yuheng.codingassessment.domain.usecase

import com.yuheng.codingassessment.domain.MovieRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    operator fun invoke() = movieRepository.getMovieInfo()
}