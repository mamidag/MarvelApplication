package com.example.marvelcharacters.api.model.data.result

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Url(
    @SerialName("type")
    var type: String? = "",
    @SerialName("url")
    var url: String? = ""
): Parcelable