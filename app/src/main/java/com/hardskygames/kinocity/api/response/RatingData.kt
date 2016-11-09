package com.hardskygames.kinocity.api.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.annotation.Generated
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder("ratingGoodReview", "ratingGoodReviewVoteCount", "rating", "ratingVoteCount", "ratingAwait", "ratingAwaitCount", "ratingIMDb", "ratingIMDbVoteCount", "ratingFilmCritics", "ratingFilmCriticsVoteCount", "ratingRFCritics", "ratingRFCriticsVoteCount")
class RatingData {

    @JsonProperty("ratingGoodReview")
    var ratingGoodReview: String = ""

    @JsonProperty("ratingGoodReviewVoteCount")
    var ratingGoodReviewVoteCount: Int = 0

    @JsonProperty("rating")
    var rating: Double = 0.toDouble()

    @JsonProperty("ratingVoteCount")
    var ratingVoteCount: String = ""

    @JsonProperty("ratingAwait")
    var ratingAwait: String = ""

    @JsonProperty("ratingAwaitCount")
    var ratingAwaitCount: String = ""

    @JsonProperty("ratingIMDb")
    var ratingIMDb: Double = 0.toDouble()

    @JsonProperty("ratingIMDbVoteCount")
    var ratingIMDbVoteCount: String = ""

    @JsonProperty("ratingFilmCritics")
    var ratingFilmCritics: String = ""

    @JsonProperty("ratingFilmCriticsVoteCount")
    var ratingFilmCriticsVoteCount: String = ""

    @JsonProperty("ratingRFCritics")
    var ratingRFCritics: String = ""

    @JsonProperty("ratingRFCriticsVoteCount")
    var ratingRFCriticsVoteCount: Int = 0
}
