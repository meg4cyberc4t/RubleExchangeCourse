package com.meg4cyberc4t.rubleexchangecourse.domain

import com.meg4cyberc4t.rubleexchangecourse.data.ValutesResponse

interface CbrRequestsService {
    suspend fun getDailyRequest() : ValutesResponse
}