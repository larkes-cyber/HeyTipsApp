package add

import NavigationTree
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew

class AddTipComponent(
    private val navigation: StackNavigation<NavigationTree>,
    componentContext: ComponentContext
):ComponentContext by componentContext {

    fun goBack(){
        navigation.pop()
    }

}