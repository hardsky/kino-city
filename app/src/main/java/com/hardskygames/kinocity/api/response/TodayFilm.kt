package com.hardskygames.kinocity.api.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.annotation.Generated
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder("type", "id", "nameRU", "nameEN", "year", "cinemaHallCount", "isNew", "rating", "posterURL", "filmLength", "country", "genre", "premiereRU", "videoURL")
class TodayFilm {

    @JsonProperty("type")
    var type: String = ""

    @JsonProperty("id")
    var id: Int = 0

    @JsonProperty("nameRU")
    var nameRU: String = ""

    @JsonProperty("nameEN")
    var nameEN: String = ""

    @JsonProperty("year")
    var year: Int = 0

    @JsonProperty("cinemaHallCount")
    var cinemaHallCount: String = ""

    @JsonProperty("isNew")
    var isNew: Int = 0

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

    @JsonProperty("premiereRU")
    var premiereRU: String = ""

    @JsonProperty("videoURL")
    var videoURL: VideoURL? = null

}
