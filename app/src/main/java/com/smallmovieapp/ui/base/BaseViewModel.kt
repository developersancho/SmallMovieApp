package com.smallmovieapp.ui.base

import androidx.lifecycle.ViewModel
import com.smallmovieapp.data.repository.DataManager
import java.lang.ref.WeakReference

abstract class BaseViewModel<N>(val dataManager: DataManager) : ViewModel() {
    lateinit var navigator: WeakReference<N>

    fun getNavigator(): N {
        return navigator.get()!!
    }

    fun setNavigator(navigator: N) {
        this.navigator = WeakReference(navigator)
    }

}