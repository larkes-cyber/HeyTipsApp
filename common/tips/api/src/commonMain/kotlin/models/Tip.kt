package models

data class Tip(
    val id:String?,
    val title:String,
    val description:String,
    val imageSrc:String?,
    val tags:TipTags?,
    val color:Long?,
    val serverId:String?
)