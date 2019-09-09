package com.smallmovieapp.ui.main

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.smallmovieapp.R
import com.smallmovieapp.data.remote.model.movie.Movie
import com.smallmovieapp.ui.base.BaseActivity
import com.smallmovieapp.utils.AppConstants
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity(), IMainNavigator, MovieListener {
    private val viewModel by viewModel<MainViewModel>()
    private val movieAdapter by lazy { MovieAdapter(arrayListOf(), this) }
    private var pageNumber = 0
    private var pageSize = 20
    private var isLoading = true
    private var isLastPage = false

    override val layoutId: Int?
        get() = R.layout.activity_main

    override fun initNavigator() {
        viewModel.setNavigator(this)
    }

    override fun initUI() {
        rv_movies.apply {
            setHasFixedSize(true)
            adapter = movieAdapter
            addOnScrollListener(recyclerViewOnScrollListener)
        }
        observeViewModel()
        initData()
        swipe_refresh_movie.setOnRefreshListener {
            refreshTable()
            swipe_refresh_movie.isRefreshing = false
        }
    }

    private fun refreshTable() {
        rv_movies.scrollToPosition(0)
        movieAdapter.clearData()
        pageNumber = 0
        loadMoreItems()

    }

    private fun initData() {
        loadMoreItems()
    }

    private fun loadMoreItems() {
        isLoading = true
        pageNumber += 1
        viewModel.getPopularMovies(
            AppConstants.TMDB_API_KEY,
            "en-US",
            pageNumber,
            "US",
            "2|3",
            "tr"
        )
    }

    private fun loadAdapter(movies: ArrayList<Movie>) {
        if (movies.isNotEmpty()) {
            if (movies.size < pageSize) {
                isLastPage = true
            }
            movieAdapter.addData(movies)
            isLoading = false
            return
        }
    }

    private val recyclerViewOnScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            var visibleItemCount = (recyclerView.layoutManager as LinearLayoutManager).childCount
            var totalItemCount = (recyclerView.layoutManager as LinearLayoutManager).itemCount
            var firstVisibleItemPosition =
                (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

            if (!isLastPage && !isLoading)
                if (totalItemCount <= (firstVisibleItemPosition + visibleItemCount)) {
                    loadMoreItems()
                }
        }
    }

    private fun observeViewModel() {
        viewModel.movies.observe(this, Observer {
            showEmptyList(it?.size == 0)
            Toast.makeText(this, it.size.toString(), Toast.LENGTH_LONG).show()
            loadAdapter(ArrayList(it))
        })
    }

    private fun showEmptyList(show: Boolean) {
        if (show) {
            emptyPopularList.visibility = View.VISIBLE
            rv_movies.visibility = View.GONE
        } else {
            emptyPopularList.visibility = View.GONE
            rv_movies.visibility = View.VISIBLE
        }
    }

    override fun initListener() {

    }

    override fun onMovieClick(movie: Movie) {
        Snackbar.make(root_main, movie.overview.toString(), Snackbar.LENGTH_LONG).show()
        /*val detailIntent = Intent(this, DetailActivity::class.java)
        detailIntent.putExtra("movie", movie)
        startActivity(detailIntent)*/
    }

}