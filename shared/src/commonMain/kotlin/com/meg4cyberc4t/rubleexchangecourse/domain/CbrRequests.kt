package com.meg4cyberc4t.rubleexchangecourse.domain

import com.meg4cyberc4t.rubleexchangecourse.data.ValutesResponse
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Headers

interface CbrRequests {
    @Headers("Content-Type: application/json")
    @GET("daily_json.js")
    suspend fun getDailyRequest() : String
}