package com.meg4cyberc4t.rubleexchangecourse.data

import kotlinx.datetime.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ValutesResponse(
    @SerialName("Date")
    val date: Instant,
    @SerialName("PreviousDate")
    val previousDate: Instant,
    @SerialName("PreviousURL")
    val previousURL: String,
    @SerialName("Timestamp")
    val timestamp: Instant,
    @SerialName("Valute")
    val valute: Map<String, ValuteItem>,
)
