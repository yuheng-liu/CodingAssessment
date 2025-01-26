package com.yuheng.codingassessment

import com.yuheng.codingassessment.data.MovieRepositoryImpl
import com.yuheng.codingassessment.data.network.OpenMovieDatabaseService
import com.yuheng.codingassessment.domain.entities.Movie
import com.yuheng.codingassessment.domain.entities.OpenMovieDatabaseResponse
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Response

private const val API_KEY = "8d6aa4ca"

class MovieRepositoryTest {

    private lateinit var service: OpenMovieDatabaseService
    private lateinit var repository: MovieRepositoryImpl

    private val movies = listOf(
        Movie("MovieTitle1"),
        Movie("MovieTitle2"),
    )

    @Before
    fun setup() {
        service = mockk<OpenMovieDatabaseService>()
        repository = MovieRepositoryImpl(service)
    }
    @Test
    fun getMoviesFromTitle_success() = runTest {
        // when api call returns success
        coEvery { service.downloadMovies("MovieTitle", API_KEY) } returns Response.success(
            OpenMovieDatabaseResponse(movies)
        )
        // execute function
        repository.getMoviesFromTitle("MovieTitle")
        // verify function called and result valid
        coVerify { service.downloadMovies("MovieTitle", API_KEY) }
        Assert.assertEquals(repository.getMovieInfo().value, movies)
    }

    @Test
    fun getMoviesFromTitle_error() = runTest {
        // when api call returns failed
        coEvery { service.downloadMovies("MovieTitle", API_KEY) } returns Response.error(500,
            "getMoviesFromTitle Error".toResponseBody()
        )
        // execute function
        repository.getMoviesFromTitle("MovieTitle")
        // verify function called and error body
        coVerify { service.downloadMovies("MovieTitle", API_KEY) }
        Assert.assertEquals(repository.getMovieInfo().value, emptyList<Movie>())
    }
}