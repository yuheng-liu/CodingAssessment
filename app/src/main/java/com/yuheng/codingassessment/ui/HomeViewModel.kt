package com.yuheng.codingassessment.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yuheng.codingassessment.repos.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    val movieInfoFlow = MovieRepository.movieInfo

    fun searchMovie(title: String) = viewModelScope.launch(Dispatchers.IO) {
        MovieRepository.getMoviesFromTitle(title)
    }
}