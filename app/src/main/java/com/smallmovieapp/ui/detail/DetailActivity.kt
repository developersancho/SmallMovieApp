package com.smallmovieapp.ui.detail

import com.smallmovieapp.R
import com.smallmovieapp.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : BaseActivity(), IDetailNavigator {
    private val viewModel by viewModel<DetailViewModel>()

    override val layoutId: Int?
        get() = R.layout.activity_detail

    override fun initNavigator() {
        viewModel.setNavigator(this)
    }

    override fun initUI() {

    }

    override fun initListener() {

    }

}
