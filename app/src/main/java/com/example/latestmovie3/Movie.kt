package com.example.latestmovie3

import android.support.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Movie(
    @SerialName("title")
    var title: String? = null,

    @SerialName("overview")
    var overview: String? = null,

    @JvmField
    @SerialName("poster_path")
    var poster_path: String? = null,

    @JvmField
    @SerialName("release_date")
    var release_date: String? = null,

    @JvmField
    @SerialName("vote_average")
    var vote_average: String? = null,

    @SerialName("popularity")
    var popularity: String? = null,


    ) : java.io.Serializable
