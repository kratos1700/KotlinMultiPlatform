package org.example.dragonball

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform