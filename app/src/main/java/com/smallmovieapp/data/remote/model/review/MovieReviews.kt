package com.smallmovieapp.data.remote.model.review

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MovieReviews {
    @SerializedName("results")
    @Expose
    var reviews: List<MovieReview>? = null
}