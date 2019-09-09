package com.smallmovieapp.ui.main

import androidx.lifecycle.MutableLiveData
import com.smallmovieapp.data.remote.model.movie.Movie
import com.smallmovieapp.data.remote.network.ResultWrapper
import com.smallmovieapp.data.repository.DataManager
import com.smallmovieapp.ui.base.BaseViewModel
import kotlinx.coroutines.*

class MainViewModel(dataManager: DataManager) : BaseViewModel<IMainNavigator>(dataManager) {
    val movies: MutableLiveData<List<Movie>> = MutableLiveData()

    fun getPopularMovies(
        apiKey: String,
        language: String,
        pageNumber: Int,
        region: String,
        releaseType: String,
        langCode: String
    ) {
        getNavigator().showLoading()
        GlobalScope.launch(Dispatchers.Main) {
            when (val result = withContext(Dispatchers.IO) {
                dataManager.getPopularMoviesAsync(apiKey, language, pageNumber, region, releaseType, langCode)
            }) {
                is ResultWrapper.Success -> {
                    movies.value = result.data.results
                    getNavigator().hideLoading()
                }
                is ResultWrapper.Error -> {
                    getNavigator().hideLoading()
                    getNavigator().onError(result.exception.message, result.exception.code)
                }
            }
        }
    }
}