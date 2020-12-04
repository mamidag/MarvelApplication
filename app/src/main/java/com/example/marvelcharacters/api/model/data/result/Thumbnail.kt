package com.example.marvelcharacters.api.model.data.result

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Thumbnail(
    @SerialName("path")
    var path: String? = "",
    @SerialName("extension")
    var extension: String? = ""
): Parcelable