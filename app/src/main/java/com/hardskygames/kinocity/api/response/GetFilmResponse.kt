package com.hardskygames.kinocity.api.response

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
    var webURL: String = ""

    @JsonProperty("nameRU")
    var nameRU: String = ""

    @JsonProperty("nameEN")
    var nameEN: String = ""

    @JsonProperty("posterURL")
    var posterURL: String = ""

    @JsonProperty("year")
    var year: Int = 0

    @JsonProperty("filmLength")
    var filmLength: String = ""

    @JsonProperty("country")
    var country: String = ""

    @JsonProperty("genre")
    var genre: String = ""

    @JsonProperty("slogan")
    var slogan: String = ""

    @JsonProperty("description")
    var description: String = ""

    @JsonProperty("videoURL")
    var videoURL: VideoURL? = null

    @JsonProperty("ratingMPAA")
    var ratingMPAA: String = ""

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
    var imdbID: String = ""
}
