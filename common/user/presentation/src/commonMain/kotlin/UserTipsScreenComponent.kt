import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation

class UserTipsScreenComponent(
    private val navigation:StackNavigation<NavigationTree>,
    componentContext: ComponentContext
):ComponentContext by componentContext {

}