package com.smallmovieapp.ui.splash

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import com.smallmovieapp.data.repository.DataManager
import com.smallmovieapp.ui.base.BaseViewModel

class SplashViewModel(dataManager: DataManager) : BaseViewModel<ISplashNavigator>(dataManager) {
    val isFinished = MutableLiveData<Boolean>()

    init {
        object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                isFinished.postValue(true)
            }
        }.start()
    }

}