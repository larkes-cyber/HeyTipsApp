package list

import NavigationTree
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.pushNew
import list.models.AdminTipsEvent

class AdminTipsComponent(
    private val navigation: StackNavigation<NavigationTree>,
    componentContext: ComponentContext
):ComponentContext by componentContext {


    fun obtainEvent(adminTipsEvent: AdminTipsEvent){

        when(adminTipsEvent){

            is AdminTipsEvent.AddIconClicked -> {
                obtainAddIconClicked()
            }

        }

    }

    private fun obtainAddIconClicked() {
        navigation.pushNew(NavigationTree.AddTipScreen)
    }


}