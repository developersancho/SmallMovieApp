package com.smallmovieapp.data.remote

import com.smallmovieapp.data.remote.model.movie.MovieResponse
import com.smallmovieapp.data.remote.network.ResultWrapper

interface IRemoteDataManager {
    suspend fun getPopularMoviesAsync(
        apiKey: String,
        language: String,
        pageNumber: Int,
        region: String,
        releaseType: String,
        langCode: String
    ): ResultWrapper<MovieResponse>
}