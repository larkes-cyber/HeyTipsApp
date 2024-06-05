class DesktopPlatform : Platform {
    override val name: String = "dESCTOP"
}

actual fun getPlatform(): Platform = DesktopPlatform()