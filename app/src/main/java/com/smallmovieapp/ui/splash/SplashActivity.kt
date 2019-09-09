package com.smallmovieapp.ui.splash

import android.content.Intent
import androidx.lifecycle.Observer
import com.smallmovieapp.R
import com.smallmovieapp.ui.main.MainActivity
import com.smallmovieapp.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : BaseActivity(), ISplashNavigator {
    private val viewModel by viewModel<SplashViewModel>()

    override val layoutId: Int?
        get() = R.layout.activity_splash

    override fun initNavigator() {
        viewModel.setNavigator(this)
    }

    override fun initUI() {
        viewModel.isFinished.observe(this@SplashActivity, Observer {
            startActivity(Intent(this, MainActivity::class.java))
        })
    }

    override fun initListener() {

    }
}
