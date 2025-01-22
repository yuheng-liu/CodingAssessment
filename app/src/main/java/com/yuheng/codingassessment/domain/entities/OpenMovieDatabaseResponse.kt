package com.yuheng.codingassessment.domain.entities

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