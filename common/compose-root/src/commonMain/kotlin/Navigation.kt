import add.AddTipComponent
import add.AddTipScreen
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import list.AdminTipsScreen
import tips_list.UserTipsScreen

@Composable
fun Navigation(root: RootComponent) {


    val childStack by root.childStack.subscribeAsState()

    Children(
        stack = childStack,
        animation = stackAnimation(slide())
    ){child ->
        when(val instance = child.instance){
            is Child.AuthScreen -> AuthScreen(instance.component)
            is Child.UserTipsListScreen -> UserTipsScreen(instance.component)
            is Child.AdminTipsListScreen -> AdminTipsScreen(instance.component)
            is Child.AddTipScreen -> AddTipScreen(instance.component)
        }

    }

}