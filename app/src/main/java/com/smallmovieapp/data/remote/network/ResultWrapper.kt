package com.smallmovieapp.data.remote.network

sealed class ResultWrapper<out T : Any> {
    class Success<out T : Any>(val data: T) : ResultWrapper<T>()
    class Error(val exception: RemoteDataException) : ResultWrapper<Nothing>()
}