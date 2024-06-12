import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import list.AdminTipsListComponent

class RootComponent(
    componentContext: ComponentContext
):ComponentContext by componentContext {

    private val navigation = StackNavigation<NavigationTree>()

    val childStack = childStack(
        source = navigation,
        serializer = NavigationTree.serializer(),
        initialConfiguration = NavigationTree.AuthScreen,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(
        config: NavigationTree,
        context: ComponentContext
    ): Child {
        return when(config) {
            NavigationTree.AuthScreen -> Child.AuthScreen(
                AuthScreenComponent(
                    componentContext = context,
                    navigation = navigation
                )
            )
            NavigationTree.AdminTipsListScreen -> Child.AdminTipsListScreen(
                AdminTipsListComponent(
                    componentContext = context,
                    navigation = navigation
                )
            )
            NavigationTree.UserTipsListScreen -> Child.UserTipsListScreen(
                UserTipsScreenComponent(
                    componentContext = context,
                    navigation = navigation
                )
            )

        }
    }

}