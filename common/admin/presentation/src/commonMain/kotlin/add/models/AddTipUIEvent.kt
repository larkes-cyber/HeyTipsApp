package add.models


sealed class AddTipUIEvent {
    data class ImageUploaded(val file:ByteArray):AddTipUIEvent()
    data class TitleChanged(val title:String):AddTipUIEvent()
    data class DescriptionChanged(val description:String):AddTipUIEvent()
    data class TagClicked(val tag:String):AddTipUIEvent()
    data class ColorSelected(val color:Long):AddTipUIEvent()
    data object BackArrowClicked:AddTipUIEvent()
    data object AddClicked:AddTipUIEvent()

}