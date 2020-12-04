package com.example.marvelcharacters.api.model.data.result.stories

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Parcelize
@Serializable
data class Stories(
    @SerialName("available")
    var available: Int? = 0,
    @SerialName("collectionURI")
    var collectionURI: String? = "",
    @SerialName("items")
    var items: List<Item?>? = nullable,
    @SerialName("returned")
    var returned: Int? = 0
): Parcelable

var nullable: List<Item> = emptyList()

