package com.meg4cyberc4t.rubleexchangecourse.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ValuteItem(
    @SerialName("ID")
    val id: String,
    @SerialName("NumCode")
    val numCode: String,
    @SerialName("CharCode")
    val charCode: String,
    @SerialName("Nominal")
    val nominal: Int,
    @SerialName("Name")
    val name: String,
    @SerialName("Value")
    val value: Float,
    @SerialName("Previous")
    val previous: Float,
)
