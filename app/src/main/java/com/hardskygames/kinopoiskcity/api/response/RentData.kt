package com.hardskygames.kinopoiskcity.api.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.annotation.Generated
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder("premiereRU", "Distributors", "premiereWorld", "premiereWorldCountry")
class RentData {

    @JsonProperty("premiereRU")
    var premiereRU: String = ""

    @JsonProperty("Distributors")
    var distributors: String = ""

    @JsonProperty("premiereWorld")
    var premiereWorld: String = ""

    @JsonProperty("premiereWorldCountry")
    var premiereWorldCountry: String = ""
}
