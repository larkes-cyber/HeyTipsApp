import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.pushNew
import di.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import models.UserTipsEvent
import models.UserTipsUIState

class UserTipsScreenComponent(
    private val navigation:StackNavigation<NavigationTree>,
    componentContext: ComponentContext
):ComponentContext by componentContext {

    private val repository = Inject.di.get<UserRepository>()

    private val _tipsUIState = MutableStateFlow(UserTipsUIState())
    val tipsUIState: StateFlow<UserTipsUIState> = _tipsUIState

    fun obtainEvent(adminTipsEvent: UserTipsEvent){

        when(adminTipsEvent){
            is UserTipsEvent.ListEnded -> {
                fetchNextTips()
            }

            is UserTipsEvent.ScreenOpened -> {
                obtainScreenOpened()
            }

            is UserTipsEvent.RefreshPulled -> {
                obtainRefreshPulled()
            }
        }

    }

    private fun obtainRefreshPulled() {
        _tipsUIState.value = UserTipsUIState()
        fetchNextTips(true)
    }

    private fun obtainScreenOpened() {
        _tipsUIState.value = UserTipsUIState(loaderActive = true)
    }

    private fun fetchNextTips(refresh:Boolean = false){
        _tipsUIState.value = _tipsUIState.value.copy(isLoading = true)
        CoroutineScope(Dispatchers.Default).launch {
            println("fetched ${tipsUIState.value.offset}")
            val tips = repository.fetchTips(limit = 5, offset = tipsUIState.value.offset, refresh = refresh)
            if(tips.isEmpty()){
                _tipsUIState.value = tipsUIState.value.copy(loaderActive = false)
                return@launch
            }
            _tipsUIState.value = tipsUIState.value.copy(list = tipsUIState.value.list + tips, offset = tipsUIState.value.offset + tips.size, isLoading = false)
        }
    }

}