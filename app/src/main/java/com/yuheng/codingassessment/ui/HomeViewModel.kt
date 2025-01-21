package com.yuheng.codingassessment.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yuheng.codingassessment.repos.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieRepository: MovieRepository
): ViewModel() {

    val movieInfoFlow = movieRepository.getMovieInfo()

    fun searchMovie(title: String) = viewModelScope.launch(Dispatchers.IO) {
        movieRepository.getMoviesFromTitle(title)
    }
}