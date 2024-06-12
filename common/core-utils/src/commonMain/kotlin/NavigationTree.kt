import kotlinx.serialization.Serializable

@Serializable
sealed class NavigationTree{
    @Serializable
    data object AuthScreen:NavigationTree()
    @Serializable
    data object AdminTipsListScreen:NavigationTree()
    @Serializable
    data object UserTipsListScreen:NavigationTree()
}