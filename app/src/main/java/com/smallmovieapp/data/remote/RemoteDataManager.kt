package com.smallmovieapp.data.remote

import com.smallmovieapp.data.remote.model.movie.MovieResponse
import com.smallmovieapp.data.remote.network.RemoteDataException
import com.smallmovieapp.data.remote.network.ResultWrapper
import com.smallmovieapp.data.remote.service.IMovieService
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class RemoteDataManager(private val movieService: IMovieService) : IRemoteDataManager {
    override suspend fun getPopularMoviesAsync(
        apiKey: String,
        language: String,
        pageNumber: Int,
        region: String,
        releaseType: String,
        langCode: String
    ): ResultWrapper<MovieResponse> =
        withContext(Dispatchers.IO) {
            resultWrapper(
                movieService.getPopularMoviesAsync(
                    apiKey,
                    language,
                    pageNumber,
                    region,
                    releaseType,
                    langCode
                )
            )
        }


    private suspend inline fun <reified T : Any> resultWrapper(request: Deferred<Response<T>>): ResultWrapper<T> {
        return try {
            val response = request.await()
            if (response.isSuccessful) {
                ResultWrapper.Success(response.body()!!)
            } else {
                ResultWrapper.Error(RemoteDataException(response.errorBody()))
            }
        } catch (ex: Throwable) {
            ResultWrapper.Error(RemoteDataException(ex))
        }
    }

}