package models

sealed class UserTipsEvent {
    data object ListEnded:UserTipsEvent()
    data object ScreenOpened:UserTipsEvent()
    data object RefreshPulled:UserTipsEvent()

}