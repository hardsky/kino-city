package com.hardskygames.kinopoiskcity.api.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.annotation.Generated
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder("id", "type", "nameRU", "nameEN", "posterURL", "professionText", "professionKey")
class Creator {

    @JsonProperty("id")
    var id: Int = 0

    @JsonProperty("type")
    var type: String? = null

    @JsonProperty("nameRU")
    var nameRU: String? = null

    @JsonProperty("nameEN")
    var nameEN: String? = null

    @JsonProperty("posterURL")
    var posterURL: String? = null

    @JsonProperty("professionText")
    var professionText: String? = null

    @JsonProperty("professionKey")
    var professionKey: String? = null
}
