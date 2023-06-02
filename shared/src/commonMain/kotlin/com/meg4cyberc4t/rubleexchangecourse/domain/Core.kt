package com.meg4cyberc4t.rubleexchangecourse.domain

import de.jensklingenberg.ktorfit.ktorfit
import de.jensklingenberg.ktorfit.converter.builtin.CallConverterFactory
import de.jensklingenberg.ktorfit.converter.builtin.FlowConverterFactory
import io.ktor.client.*
import io.ktor.client.plugins.addDefaultResponseValidation
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.KotlinxSerializationConverter
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


val ktorfit = ktorfit {
    baseUrl("https://www.cbr-xml-daily.ru/")
    HttpClient() {
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                },
            )
            addDefaultResponseValidation()
            expectSuccess = true
        }
    }
}

val cbrRequests = ktorfit.create<CbrRequests>()
