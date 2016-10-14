package com.hardskygames.kinopoiskcity.api.response

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
    var type: String? = null

    @JsonProperty("id")
    var id: Int = 0

    @JsonProperty("nameRU")
    var nameRU: String? = null

    @JsonProperty("nameEN")
    var nameEN: String? = null

    @JsonProperty("year")
    var year: Int = 0

    @JsonProperty("cinemaHallCount")
    var cinemaHallCount: String? = null

    @JsonProperty("isNew")
    var isNew: Int = 0

    @JsonProperty("rating")
    var rating: String? = null

    @JsonProperty("posterURL")
    var posterURL: String? = null

    @JsonProperty("filmLength")
    var filmLength: String? = null

    @JsonProperty("country")
    var country: String? = null

    @JsonProperty("genre")
    var genre: String? = null

    @JsonProperty("premiereRU")
    var premiereRU: String? = null

    @JsonProperty("videoURL")
    var videoURL: VideoURL? = null

}
