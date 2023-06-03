package com.meg4cyberc4t.rubleexchangecourse.domain

import com.meg4cyberc4t.rubleexchangecourse.data.ValutesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.*

class CbrRequestsServiceImpl(
    private val networkClient: HttpClient,
) : CbrRequestsService {
    override suspend fun getDailyRequest(): ValutesResponse {
        return networkClient.get("https://www.cbr-xml-daily.ru/daily_json.js").body();
    }
}