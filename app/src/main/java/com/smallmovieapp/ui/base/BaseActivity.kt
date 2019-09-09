package com.smallmovieapp.ui.base

import android.app.AlertDialog
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.smallmovieapp.utils.LoadingDialog


abstract class BaseActivity : AppCompatActivity(), IBaseNavigator {
    @get:LayoutRes
    protected abstract val layoutId: Int?

    protected abstract fun initNavigator()

    protected abstract fun initUI()

    protected abstract fun initListener()

    private val dialog: AlertDialog by lazy {
        LoadingDialog.Builder().setContext(this)
            .setCancelable(false)
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutId?.let { setContentView(it) }
        initNavigator()
        initUI()
        initListener()
    }


    override fun showLoading() {
        dialog.show()
    }

    override fun hideLoading() {
        dialog.dismiss()
    }

    override fun onError(errorMessage: String, errorCode: Int) {

    }
}