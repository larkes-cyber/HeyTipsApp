package models

data class AdminTip(
    val id:String? = null,
    var title:String,
    val description:String,
    val imageSrc:String? = null,
    val tags:AdminTipTags? = null,
    val color:Long? = null,
    var serverId:String? = null
)