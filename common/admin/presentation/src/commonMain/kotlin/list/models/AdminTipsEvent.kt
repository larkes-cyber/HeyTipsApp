package list.models

sealed class AdminTipsEvent {
    data object AddIconClicked:AdminTipsEvent()
    data object ListEnded:AdminTipsEvent()
    data object ScreenOpened:AdminTipsEvent()

}