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
@JsonPropertyOrder("cinemaID", "address", "lon", "lat", "cinemaName", "seance")
class Cinema {

    @JsonProperty("cinemaID")
    var cinemaID: Int = 0

    @JsonProperty("address")
    var address: String = ""

    @JsonProperty("lon")
    var lon: Double = 0.toDouble()

    @JsonProperty("lat")
    var lat: Double = 0.toDouble()

    @JsonProperty("cinemaName")
    var cinemaName: String = ""

    @JsonProperty("seance")
    var seance: List<Seance> = ArrayList()
}
