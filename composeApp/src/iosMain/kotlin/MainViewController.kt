import androidx.compose.ui.window.ComposeUIViewController
import androidx.navigation.compose.rememberNavController

fun MainViewController() = ComposeUIViewController {
    PlatformSDK.init(PlatformConfiguration())
    App()
}