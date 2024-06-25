package add

import AdminRepository
import NavigationTree
import add.models.AddTipUIAction
import add.models.AddTipUIEvent
import add.models.AddTipUIState
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import di.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.observeOn
import kotlinx.coroutines.launch
import models.AdminTip
import models.AdminTipTags

class AddTipComponent(
    val navigation: StackNavigation<NavigationTree>,
    componentContext: ComponentContext
):ComponentContext by componentContext {

    private val repository = Inject.di.get<AdminRepository>()

    private val _addTipUIState = MutableStateFlow(AddTipUIState())
    val addTipUIState:StateFlow<AddTipUIState> = _addTipUIState

    private val _addTipUIAction = MutableStateFlow<AddTipUIAction?>(null)
    val addTipUIAction:StateFlow<AddTipUIAction?> = _addTipUIAction

    fun onEvent(event:AddTipUIEvent){
        when(event){
            is AddTipUIEvent.ImageUploaded -> {
                obtainImageUploaded(event.file)
            }
            is AddTipUIEvent.TitleChanged -> {
                obtainTitleChanged(event.title)
            }
            is AddTipUIEvent.TagClicked -> {
                obtainTagClicked(event.tag)
            }
            is AddTipUIEvent.DescriptionChanged -> {
                obtainDescriptionChanged(event.description)
            }
            is AddTipUIEvent.ColorSelected -> {
                obtainColorSelected(event.color)
            }
            is AddTipUIEvent.BackArrowClicked -> {
                obtainBackArrowClicked()
            }
            is AddTipUIEvent.AddClicked -> {
                addClicked()
            }
        }
    }

    private fun addClicked() {
        CoroutineScope(Dispatchers.Default).launch {

            val imageURL = try {
                addTipUIState.value.image?.let {
                    repository.uploadPhoto(file = it)
                }
            }catch (e:Exception){ null }
            repository.addTip(AdminTip(
                title = addTipUIState.value.title,
                description = addTipUIState.value.description,
                imageSrc = imageURL,
                tags = AdminTipTags(tags = addTipUIState.value.selectedTags),
                color = addTipUIState.value.selectedColor
                 )
            )

            obtainBackArrowClicked()
        }
    }

    private fun obtainBackArrowClicked() {
        navigation.pop()
    }

    private fun obtainColorSelected(color: Long) {
        _addTipUIState.value = addTipUIState.value.copy(selectedColor = color)
    }

    private fun obtainDescriptionChanged(text: String) {
        _addTipUIState.value = addTipUIState.value.copy(description = text)
    }

    private fun obtainTagClicked(tag: String) {
        val tags = addTipUIState.value.selectedTags.toMutableList()
        if(tags.contains(tag)) tags.remove(tag)
        else tags.add(tag)
        _addTipUIState.value = addTipUIState.value.copy(selectedTags = tags)
    }

    private fun obtainTitleChanged(title: String) {
        _addTipUIState.value = addTipUIState.value.copy(title = title)
    }

    private fun obtainImageUploaded(bytes: ByteArray) {
        _addTipUIState.value = addTipUIState.value.copy(image = bytes)
    }


}