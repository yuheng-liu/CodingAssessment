package com.yuheng.codingassessment.models

data class OpenMovieDatabaseResponse(
    val Search: List<Movie> = emptyList(),
)

data class Movie(
    val Title: String = "",
    val Year: String = "",
    val imdbID: String = "",
    val Type: String = "",
    val Poster: String = "",
)