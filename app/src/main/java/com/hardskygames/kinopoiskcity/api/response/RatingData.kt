package com.hardskygames.kinopoiskcity.api.response

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
    var ratingGoodReview: String? = null

    @JsonProperty("ratingGoodReviewVoteCount")
    var ratingGoodReviewVoteCount: Int = 0

    @JsonProperty("rating")
    var rating: Double = 0.toDouble()

    @JsonProperty("ratingVoteCount")
    var ratingVoteCount: String? = null

    @JsonProperty("ratingAwait")
    var ratingAwait: String? = null

    @JsonProperty("ratingAwaitCount")
    var ratingAwaitCount: String? = null

    @JsonProperty("ratingIMDb")
    var ratingIMDb: Double = 0.toDouble()

    @JsonProperty("ratingIMDbVoteCount")
    var ratingIMDbVoteCount: String? = null

    @JsonProperty("ratingFilmCritics")
    var ratingFilmCritics: String? = null

    @JsonProperty("ratingFilmCriticsVoteCount")
    var ratingFilmCriticsVoteCount: String? = null

    @JsonProperty("ratingRFCritics")
    var ratingRFCritics: String? = null

    @JsonProperty("ratingRFCriticsVoteCount")
    var ratingRFCriticsVoteCount: Int = 0
}
