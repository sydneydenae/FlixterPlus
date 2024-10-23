package com.example.latestmovie3

import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Movie(
    @SerialName("title")
    var title: String? = null,

    @SerialName("overview")
    var overview: String? = null,

    @SerialName("poster_path")
    var posterPath: String? = null
) : java.io.Serializable
