package models

sealed class AuthEvent {
    data object AdminClicked:AuthEvent()
    data object UserClicked:AuthEvent()
}