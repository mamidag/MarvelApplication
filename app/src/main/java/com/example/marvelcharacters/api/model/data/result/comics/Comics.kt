package com.example.marvelcharacters.api.model.data.result.comics
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Parcelize
@Serializable
data class Comics(
    @SerialName("resourceURI")
    var resourceURI: String? = "",
    @SerialName("name")
    var name: String? = "",
    @SerialName("items")
    var items: List<Item?>? = nullable
): Parcelable

var nullable :  List<Item> = emptyList()