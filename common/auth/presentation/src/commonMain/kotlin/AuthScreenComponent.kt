import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.pushNew

class AuthScreenComponent(
    private val navigation:StackNavigation<NavigationTree>,
    componentContext: ComponentContext
):ComponentContext by componentContext {

    fun adminNavigate(){
        navigation.pushNew(NavigationTree.AdminTipsListScreen)
    }

    fun userNavigate(){
        navigation.pushNew(NavigationTree.UserTipsListScreen)
    }

}