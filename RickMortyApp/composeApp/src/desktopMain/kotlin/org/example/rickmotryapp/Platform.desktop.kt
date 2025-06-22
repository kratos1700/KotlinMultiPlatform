package org.example.rickmotryapp


class DesktopPlatform : Platform {
    override val name: String = "Soy escritorio"
}



actual fun getPlatform(): Platform = DesktopPlatform()