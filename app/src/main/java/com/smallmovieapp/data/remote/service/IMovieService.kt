package com.smallmovieapp.data.remote.service

import com.smallmovieapp.data.remote.model.credit.MovieCredit
import com.smallmovieapp.data.remote.model.movie.MovieDetail
import com.smallmovieapp.data.remote.model.movie.MovieResponse
import com.smallmovieapp.data.remote.model.review.MovieReviews
import com.smallmovieapp.data.remote.model.video.MovieVideos
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IMovieService {
    @GET("movie/popular")
    fun getPopularMoviesAsync(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") pageNumber: Int,
        @Query("region") region: String,
        @Query("with_release_type") releaseType: String,
        @Query("language") langCode: String
    ): Deferred<Response<MovieResponse>>

    @GET("movie/now_playing")
    fun getNowShowingMoviesAsync(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") pageNumber: Int,
        @Query("region") region: String,
        @Query("with_release_type") releaseType: String,
        @Query("language") langCode: String
    ): Deferred<Response<MovieResponse>>

    @GET("movie/top_rated")
    fun getTopRatedMoviesAsync(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") pageNumber: Int,
        @Query("region") region: String,
        @Query("with_release_type") releaseType: String,
        @Query("language") langCode: String
    ): Deferred<Response<MovieResponse>>

    @GET("movie/upcoming")
    fun getUpcomingMoviesAsync(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") pageNumber: Int,
        @Query("region") region: String,
        @Query("with_release_type") releaseType: String,
        @Query("language") langCode: String
    ): Deferred<Response<MovieResponse>>

    @GET("movie/{movieId}/recommendations")
    fun getRecommendedMoviesAsync(
        @Path("movieId") movieId: String,
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") pageNumber: Int,
        @Query("language") langCode: String
    ): Deferred<Response<MovieResponse>>

    @GET("search/movie")
    fun getSearchMoviesAsync(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("query") query: String,
        @Query("page") pageNumber: Int,
        @Query("include_adult") adult: String,
        @Query("region") region: String,
        @Query("with_release_type") releaseType: String,
        @Query("language") langCode: String
    ): Deferred<Response<MovieResponse>>

    @GET("movie/{movieId}")
    fun getDetailMovieAsync(
        @Path("movieId") movieId: String,
        @Query("api_key") apiKey: String,
        @Query("append_to_response") response: String,
        @Query("language") langCode: String
    ): Deferred<Response<MovieDetail>>

    @GET("movie/{id}/videos")
    fun getMovieVideosAsync(@Path("id") id: Long, @Query("api_key") apiKey: String): Deferred<Response<MovieVideos>>

    @GET("movie/{id}/reviews")
    fun getMovieReviewsAsync(@Path("id") id: Long, @Query("api_key") apiKey: String): Deferred<Response<MovieReviews>>

    @GET("movie/{id}/credits")
    fun getMovieCreditsAsync(@Path("id") id: Long, @Query("api_key") apiKey: String): Deferred<Response<MovieCredit>>
}