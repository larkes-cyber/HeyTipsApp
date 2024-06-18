package list

import AdminRepository
import NavigationTree
import add.models.AddTipUIState
import androidx.compose.runtime.State
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.pushNew
import di.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import list.models.AdminTipsEvent
import list.models.AdminTipsUIState

class AdminTipsComponent(
    private val navigation: StackNavigation<NavigationTree>,
    componentContext: ComponentContext
):ComponentContext by componentContext {

    private val repository = Inject.di.get<AdminRepository>()

    private val _tipsUIState = MutableStateFlow(AdminTipsUIState())
    val tipsUIState:StateFlow<AdminTipsUIState> = _tipsUIState

    init {
        fetchNextTips()
    }

    fun obtainEvent(adminTipsEvent: AdminTipsEvent){

        when(adminTipsEvent){

            is AdminTipsEvent.AddIconClicked -> {
                obtainAddIconClicked()
            }

        }

    }

    private fun fetchNextTips(){
        CoroutineScope(Dispatchers.IO).launch {
            val tips = repository.fetchTips(limit = 5, offset = tipsUIState.value.offset, refresh = false)
            _tipsUIState.value = tipsUIState.value.copy(list = tips, offset = tipsUIState.value.offset + tips.size)
        }
    }

    private fun obtainAddIconClicked() {
        navigation.pushNew(NavigationTree.AddTipScreen)
    }


}