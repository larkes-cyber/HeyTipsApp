import list.AdminTipsListComponent

sealed class Child {
    data class AuthScreen(val component: AuthScreenComponent): Child()
    data class AdminTipsListScreen(val component: AdminTipsListComponent): Child()
    data class UserTipsListScreen(val component: UserTipsScreenComponent):Child()
}