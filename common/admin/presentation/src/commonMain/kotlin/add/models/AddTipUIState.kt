package add.models

import androidx.compose.ui.graphics.ImageBitmap

data class AddTipUIState(
    val isLoading:Boolean = false,
    val image: ByteArray? = null,
    val showingPicker:Boolean = false,
    val title:String = "",
    val description:String = "",
    val selectedTags:List<String> = listOf(),
    val selectedColor:Long? = null
)