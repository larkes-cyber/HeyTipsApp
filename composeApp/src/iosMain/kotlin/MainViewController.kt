import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry

fun MainViewController() = ComposeUIViewController {
    LaunchedEffect(Unit){
        PlatformSDK.init(PlatformConfiguration())
    }
    val root = remember {
        RootComponent(DefaultComponentContext(LifecycleRegistry()))
    }
   Navigation(root)
}