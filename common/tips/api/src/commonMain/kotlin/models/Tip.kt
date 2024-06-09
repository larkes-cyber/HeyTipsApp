package models

data class Tip(
    val id:String? = null,
    var title:String,
    val description:String,
    val imageSrc:String? = null,
    val tags:TipTags? = null,
    val color:Long? = null,
    var serverId:String? = null
)