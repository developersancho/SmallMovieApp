package com.smallmovieapp.ui.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.smallmovieapp.R
import com.smallmovieapp.data.remote.model.movie.Movie
import com.smallmovieapp.utils.DateUtils
import com.smallmovieapp.utils.Helpers
import com.smallmovieapp.utils.inflate
import kotlinx.android.synthetic.main.row_item_movie.view.*

class MovieAdapter(
    private var items: ArrayList<Movie> = arrayListOf(),
    private val listener: MovieListener
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(parent.inflate(R.layout.row_item_movie))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) =
        holder.bind(getItem(position), listener)

    private fun getItem(position: Int): Movie = items[position]

    fun addData(list: ArrayList<Movie>) {
        items.addAll(list)
        notifyDataSetChanged()
    }

    fun clearData() {
        items.clear()
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            movie: Movie,
            listener: MovieListener
        ) = with(itemView) {
            single_item_movie_title.text = movie.title
            single_item_movie_rating.rating = movie.voteAverage!!.div(2)
            single_item_movie_release_date.text = context.getString(R.string.release_date).plus(
                DateUtils.getStringDate(
                    movie.releaseDate!!
                )
            )
            single_item_movie_overview.text = movie.overview

            for (i in movie.genreIds!!.indices) {
                if (i == movie.genreIds!!.size - 1)
                    movie.genreString += Helpers.getGenre(movie.genreIds!![i])
                else
                    movie.genreString += Helpers.getGenre(movie.genreIds!![i]) + ", "
            }

            itemView.single_item_movie_type.text =
                context.getString(R.string.genre) + movie.genreString

            Glide.with(context).load(Helpers.buildImageUrl(movie.posterPath!!))
                .thumbnail(0.05f)
                .apply(
                    RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(
                        true
                    )
                )
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(single_item_movie_image)

            setOnClickListener { listener.onMovieClick(movie) }
        }
    }

}

interface MovieListener {
    fun onMovieClick(movie: Movie)
}