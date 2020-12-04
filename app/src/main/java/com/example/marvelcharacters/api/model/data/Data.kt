package com.example.marvelcharacters.api.model.data

import android.os.Parcelable
import com.example.marvelcharacters.api.model.data.result.Result
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Data(
    @SerialName("offset")
    var offset: Int? = 0,
    @SerialName("limit")
    var limit: Int? = 0,
    @SerialName("total")
    var total: Int? = 0,
    @SerialName("count")
    var count: Int? = 0,
    @SerialName("results")
    var results: List<Result>
) : Parcelable