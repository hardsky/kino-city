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
@JsonPropertyOrder("hasSimilarFilms", "reviewsCount", "ratingData", "hasRelatedFilms", "filmID", "webURL", "nameRU", "nameEN", "posterURL", "year", "filmLength", "country", "genre", "slogan", "description", "videoURL", "ratingMPAA", "ratingAgeLimits", "hasSeance", "rentData", "budgetData", "gallery", "creators", "topNewsByFilm", "triviaData", "imdbID")
class GetFilmResponse {

    @JsonProperty("hasSimilarFilms")
    var hasSimilarFilms: Int = 0

    @JsonProperty("reviewsCount")
    var reviewsCount: Int = 0

    @JsonProperty("ratingData")
    var ratingData: RatingData? = null

    @JsonProperty("hasRelatedFilms")
    var hasRelatedFilms: Int = 0

    @JsonProperty("filmID")
    var filmID: Int = 0

    @JsonProperty("webURL")
    var webURL: String? = null

    @JsonProperty("nameRU")
    var nameRU: String? = null

    @JsonProperty("nameEN")
    var nameEN: String? = null

    @JsonProperty("posterURL")
    var posterURL: String? = null

    @JsonProperty("year")
    var year: Int = 0

    @JsonProperty("filmLength")
    var filmLength: String? = null

    @JsonProperty("country")
    var country: String? = null

    @JsonProperty("genre")
    var genre: String? = null

    @JsonProperty("slogan")
    var slogan: String? = null

    @JsonProperty("description")
    var description: String? = null

    @JsonProperty("videoURL")
    var videoURL: VideoURL? = null

    @JsonProperty("ratingMPAA")
    var ratingMPAA: String? = null

    @JsonProperty("ratingAgeLimits")
    var ratingAgeLimits: Int = 0

    @JsonProperty("hasSeance")
    var hasSeance: Int = 0

    @JsonProperty("rentData")
    var rentData: RentData? = null

    @JsonProperty("budgetData")
    var budgetData: BudgetData? = null

    @JsonProperty("gallery")
    var gallery: List<Gallery> = ArrayList()

    @JsonProperty("creators")
    var creators: List<List<Creator>> = ArrayList()

    @JsonProperty("topNewsByFilm")
    var topNewsByFilm: TopNewsByFilm? = null

    @JsonProperty("triviaData")
    var triviaData: List<String> = ArrayList()

    @JsonProperty("imdbID")
    var imdbID: String? = null
}
