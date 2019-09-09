package com.smallmovieapp.data.repository

import com.smallmovieapp.data.remote.RemoteDataManager
import com.smallmovieapp.data.remote.model.movie.MovieResponse
import com.smallmovieapp.data.remote.network.ResultWrapper

class DataManager(private val remoteDataManager: RemoteDataManager) : IDataManager {
    override suspend fun getPopularMoviesAsync(
        apiKey: String,
        language: String,
        pageNumber: Int,
        region: String,
        releaseType: String,
        langCode: String
    ): ResultWrapper<MovieResponse> =
        remoteDataManager.getPopularMoviesAsync(
            apiKey,
            language,
            pageNumber,
            region,
            releaseType,
            langCode
        )

}