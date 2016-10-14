package com.hardskygames.kinopoiskcity.api.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

import java.util.ArrayList

import javax.annotation.Generated

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder("filmsData", "date")
class GetTodayFilmsResponse {

    /**
     * @return The filmsData
     */
    /**
     * @param filmsData The filmsData
     */
    @JsonProperty("filmsData")
    var films: List<TodayFilm> = ArrayList()
    /**
     * @return The date
     */
    /**
     * @param date The date
     */
    @JsonProperty("date")
    var date: String? = null

}

