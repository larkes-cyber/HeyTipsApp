import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry

fun main() = application {

    PlatformSDK.init(PlatformConfiguration())

    val root = remember {
        RootComponent(DefaultComponentContext(LifecycleRegistry()))
    }


    Window(
        onCloseRequest = ::exitApplication,
        title = "HeyTips",
    ) {
        Navigation(root)
    }
}