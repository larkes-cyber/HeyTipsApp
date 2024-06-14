import add.AddTipComponent
import list.AdminTipsComponent

sealed class Child {
    data class AuthScreen(val component: AuthComponent): Child()
    data class AdminTipsListScreen(val component: AdminTipsComponent): Child()
    data class UserTipsListScreen(val component: UserTipsScreenComponent):Child()
    data class AddTipScreen(val component:AddTipComponent):Child()
}