package list.models

sealed class AdminTipsEvent {
    data object AddIconClicked:AdminTipsEvent()
    data object ListEnded:AdminTipsEvent()
    data object ScreenOpened:AdminTipsEvent()
    data class DeleteClicked(val id:String):AdminTipsEvent()
    data object RefreshPulled:AdminTipsEvent()

}