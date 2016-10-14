package com.hardskygames.kinopoiskcity.api.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.annotation.Generated
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder("ID", "newsDate", "newsImagePreviewURL", "newsTitle", "newsDescription", "videoURL")
class TopNewsByFilm {

    @JsonProperty("ID")
    var id: Int = 0

    @JsonProperty("newsDate")
    var newsDate: String? = null

    @JsonProperty("newsImagePreviewURL")
    var newsImagePreviewURL: String? = null

    @JsonProperty("newsTitle")
    var newsTitle: String? = null

    @JsonProperty("newsDescription")
    var newsDescription: String? = null

    @JsonProperty("videoURL")
    var videoURL: String? = null
}