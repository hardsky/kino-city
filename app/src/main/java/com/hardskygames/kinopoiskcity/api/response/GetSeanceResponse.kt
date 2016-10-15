package com.hardskygames.kinopoiskcity.api.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.ArrayList
import javax.annotation.Generated
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder("cityID", "cityName", "seanceURL", "filmID", "nameRU", "nameEN", "year", "is3D", "rating", "posterURL", "filmLength", "country", "genre", "videoURL", "items", "date")
class GetSeanceResponse {

    @JsonProperty("cityID")
    var cityID: Int = 0

    @JsonProperty("cityName")
    var cityName: String = ""

    @JsonProperty("seanceURL")
    var seanceURL: String = ""

    @JsonProperty("filmID")
    var filmID: Int = 0

    @JsonProperty("nameRU")
    var nameRU: String = ""

    @JsonProperty("nameEN")
    var nameEN: String = ""

    @JsonProperty("year")
    var year: Int = 0

    @JsonProperty("is3D")
    var is3D: Int = 0

    @JsonProperty("rating")
    var rating: String = ""

    @JsonProperty("posterURL")
    var posterURL: String = ""

    @JsonProperty("filmLength")
    var filmLength: String = ""

    @JsonProperty("country")
    var country: String = ""

    @JsonProperty("genre")
    var genre: String = ""

    @JsonProperty("videoURL")
    var videoURL: VideoURL? = null

    @JsonProperty("items")
    var items: List<Cinema> = ArrayList()

    @JsonProperty("date")
    var date: String = ""
}
