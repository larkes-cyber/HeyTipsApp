package list.models

sealed class AdminTipsEvent {
    data object AddIconClicked:AdminTipsEvent()

}