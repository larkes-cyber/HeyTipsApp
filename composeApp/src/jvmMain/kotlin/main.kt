import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {

    PlatformSDK.init(PlatformConfiguration())

    Window(
        onCloseRequest = ::exitApplication,
        title = "ContactsApp",
    ) {
        App()
    }
}