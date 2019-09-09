package com.smallmovieapp.data.remote.model.credit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MovieCredit {
    @SerializedName("cast")
    @Expose()
    var castResult: List<Cast>? = null

    @SerializedName("crew")
    @Expose()
    var crewResult: List<Crew>? = null
}