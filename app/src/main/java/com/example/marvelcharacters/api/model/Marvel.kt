package com.example.marvelcharacters.api.model

import android.os.Parcelable
import com.example.marvelcharacters.api.model.data.Data
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Marvel(
    @SerialName("code")
    var code: Int? = 0,
    @SerialName("status")
    var status: String? = "",
    @SerialName("copyright")
    var copyright: String? = "",
    @SerialName("attributionText")
    var attributionText: String? = "",
    @SerialName("attributionHTML")
    var attributionHTML: String? = "",
    @SerialName("etag")
    var etag: String? = "",
    @SerialName("data")
    var data: Data
) : Parcelable