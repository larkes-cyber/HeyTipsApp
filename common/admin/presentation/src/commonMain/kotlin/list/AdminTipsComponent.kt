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
    val navigation: StackNavigation<NavigationTree>,
    componentContext: ComponentContext
):ComponentContext by componentContext {

    private val repository = Inject.di.get<AdminRepository>()

    private val _tipsUIState = MutableStateFlow(AdminTipsUIState())
    val tipsUIState:StateFlow<AdminTipsUIState> = _tipsUIState

    fun obtainEvent(adminTipsEvent: AdminTipsEvent){

        when(adminTipsEvent){

            is AdminTipsEvent.AddIconClicked -> {
                obtainAddIconClicked()
            }
            is AdminTipsEvent.ListEnded -> {
                fetchNextTips()
            }

            is AdminTipsEvent.ScreenOpened -> {
                obtainScreenOpened()
            }

            is AdminTipsEvent.DeleteClicked -> {
                obtainDeleteClicked(adminTipsEvent.id)
            }

            is AdminTipsEvent.RefreshPulled -> {
                obtainRefreshPulled()
            }

        }

    }

    private fun obtainRefreshPulled() {
        _tipsUIState.value = AdminTipsUIState()
        fetchNextTips(true)
    }

    private fun obtainDeleteClicked(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.deleteTip(id)
            obtainRefreshPulled()
        }
    }

    private fun obtainScreenOpened() {
        _tipsUIState.value = AdminTipsUIState(loaderActive = true)
    }

    private fun fetchNextTips(refresh:Boolean = false){
        _tipsUIState.value = _tipsUIState.value.copy(isLoading = true)
        CoroutineScope(Dispatchers.Default).launch {

            val tips = repository.fetchTips(limit = 5, offset = tipsUIState.value.offset, refresh = refresh)
            if(tips.isEmpty()){
                _tipsUIState.value = tipsUIState.value.copy(loaderActive = false)
                return@launch
            }
            _tipsUIState.value = tipsUIState.value.copy(list = tipsUIState.value.list + tips, offset = tipsUIState.value.offset + tips.size, isLoading = false)
        }
    }

    private fun obtainAddIconClicked() {
        navigation.pushNew(NavigationTree.AddTipScreen)
    }


}