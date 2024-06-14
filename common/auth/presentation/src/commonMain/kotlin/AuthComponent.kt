import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.pushNew
import models.AuthEvent

class AuthComponent(
    private val navigation:StackNavigation<NavigationTree>,
    componentContext: ComponentContext
):ComponentContext by componentContext {


    fun obtainEvent(authEvent: AuthEvent){

        when(authEvent){
            is AuthEvent.AdminClicked -> {
                obtainAdminClicked()
            }
            is AuthEvent.UserClicked -> {
                obtainUserClicked()
            }
        }

    }

    private fun obtainUserClicked() {
        navigation.pushNew(NavigationTree.UserTipsListScreen)
    }

    private fun obtainAdminClicked() {
        navigation.pushNew(NavigationTree.AdminTipsListScreen)
    }


}