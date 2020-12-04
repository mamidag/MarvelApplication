package com.example.marvelcharacters.api.model.data.result.events

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Events(
    @SerialName("available")
    var available: Int? = 0,
    @SerialName("collectionURI")
    var collectionURI: String? = "",
    @SerialName("items")
    var items: List<Item?>? = null,
    @SerialName("returned")
    var returned: Int? = 0
) : Parcelable

var nullable: List<Item> = emptyList()