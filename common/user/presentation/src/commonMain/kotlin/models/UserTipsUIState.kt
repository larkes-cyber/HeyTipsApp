package models


data class UserTipsUIState(
    val list:List<UserTip> = listOf(),
    val offset:Int = 1,
    val loaderActive:Boolean = true,
    val isLoading:Boolean = false,
)