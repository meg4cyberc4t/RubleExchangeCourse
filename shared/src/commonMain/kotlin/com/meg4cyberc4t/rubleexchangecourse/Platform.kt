package com.meg4cyberc4t.rubleexchangecourse

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform