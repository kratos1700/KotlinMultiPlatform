package org.example.rickmotryapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform