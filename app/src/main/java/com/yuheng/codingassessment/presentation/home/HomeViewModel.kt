package com.yuheng.codingassessment.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yuheng.codingassessment.domain.usecase.GetMoviesUseCase
import com.yuheng.codingassessment.domain.usecase.SearchMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getMoviesUseCase: GetMoviesUseCase,
    private val searchMovieUseCase: SearchMovieUseCase,
): ViewModel() {

    val movieInfoFlow = getMoviesUseCase()

    fun searchMovie(title: String) = viewModelScope.launch(Dispatchers.IO) {
        searchMovieUseCase(title)
    }
}