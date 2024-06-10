import androidx.compose.ui.window.ComposeUIViewController
import androidx.navigation.compose.rememberNavController

fun MainViewController() = ComposeUIViewController {
    PlatformSDK.init(PlatformConfiguration())
   // val navController = rememberNavController()
   // Navigation(navController)
    Text("lol")
}