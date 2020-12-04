package com.example.marvelcharacters.api.model.data.result.series

import android.os.Parcelable
import com.example.marvelcharacters.api.model.data.result.stories.Item
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Item(
    @SerialName("resourceURI")
    var resourceURI: String? = "",
    @SerialName("name")
    var name: String? = ""
): Parcelable