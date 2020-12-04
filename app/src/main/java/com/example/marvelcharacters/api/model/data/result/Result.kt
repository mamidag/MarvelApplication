package com.example.marvelcharacters.api.model.data.result


import android.os.Parcelable
import com.example.marvelcharacters.api.model.data.result.comics.Comics
import com.example.marvelcharacters.api.model.data.result.events.Events
import com.example.marvelcharacters.api.model.data.result.series.Series
import com.example.marvelcharacters.api.model.data.result.stories.Stories
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Result(
    @SerialName("id")
    var id: Int? = 0,
    @SerialName("name")
    var name: String? = "",
    @SerialName("title")
    var title: String? = "",
    @SerialName("description")
    var description: String? = "",
    @SerialName("modified")
    var modified: String? = "",
    @SerialName("resourceURI")
    var resourceURI: String? = "",
    @SerialName("urls")
    var urls: List<Url>,
    @SerialName("series")
    var series: Series,
    @SerialName("comics")
    var comics: Comics = nullable,
    @SerialName("stories")
    var stories: Stories,
    @SerialName("events")
    var events: Events,
    @SerialName("thumbnail")
    var thumbnail: Thumbnail
): Parcelable

var nullable : Comics = Comics()