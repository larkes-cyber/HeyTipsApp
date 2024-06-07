package ktor.models

import kotlinx.serialization.Serializable
import models.TipTags

@Serializable
data class AddTipRequest(
    val title:String,
    val description:String,
    val imageSrc:String?,
    val tags: TipTags?,
    val color:Long?
)