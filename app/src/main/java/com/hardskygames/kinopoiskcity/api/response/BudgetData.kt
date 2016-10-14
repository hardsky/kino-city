package com.hardskygames.kinopoiskcity.api.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.annotation.Generated
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder("grossRU", "grossUSA", "grossWorld", "budget")
class BudgetData {

    @JsonProperty("grossRU")
    var grossRU: String? = null

    @JsonProperty("grossUSA")
    var grossUSA: String? = null

    @JsonProperty("grossWorld")
    var grossWorld: String? = null

    @JsonProperty("budget")
    var budget: String? = null
}
