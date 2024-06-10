package models

data class UserTip(
    val id:String? = null,
    var title:String,
    val description:String,
    val imageSrc:String? = null,
    val tags:UserTipTags? = null,
    val color:Long? = null,
    var serverId:String? = null
)