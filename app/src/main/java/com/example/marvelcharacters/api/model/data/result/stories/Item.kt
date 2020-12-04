package com.example.marvelcharacters.api.model.data.result.stories

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Item(
    @SerialName("resourceURI")
    var resourceURI: String? = "",
    @SerialName("name")
    var name: String? = "",
    @SerialName("type")
    var type: String? = ""
): Parcelable