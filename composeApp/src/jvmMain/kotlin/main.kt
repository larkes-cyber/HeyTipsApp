import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.navigation.compose.rememberNavController

fun main() = application {

    PlatformSDK.init(PlatformConfiguration())

    val navController = rememberNavController()

    Window(
        onCloseRequest = ::exitApplication,
        title = "ContactsApp",
    ) {
        Navigation(navController)
    }
}