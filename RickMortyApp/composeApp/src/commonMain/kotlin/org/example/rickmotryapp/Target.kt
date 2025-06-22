package org.example.rickmotryapp

expect fun getCurrentTarget(): Target


enum class Target {
    IOS,
    ANDROID,
    DESKTOP,
    WEB;

}

fun isDesktop() =getCurrentTarget() == Target.DESKTOP
fun isAndroid() = getCurrentTarget() == Target.ANDROID
fun isIOS() = getCurrentTarget() == Target.IOS