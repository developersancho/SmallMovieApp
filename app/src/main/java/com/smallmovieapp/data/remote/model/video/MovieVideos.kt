package com.smallmovieapp.data.remote.model.video

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.smallmovieapp.data.remote.model.video.MovieVideo

class MovieVideos {
    @SerializedName("results")
    @Expose
    var videos: List<MovieVideo>? = null
}