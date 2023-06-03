package com.meg4cyberc4t.rubleexchangecourse.domain


import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.*

var httpClient: HttpClient = HttpClient() {
    install(ContentNegotiation) {
        json()
        json(contentType = ContentType.Application.JavaScript)
    }
}

var cbrRequests = CbrRequestsServiceImpl(httpClient)