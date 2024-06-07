package models

import kotlinx.serialization.Serializable


@Serializable
data class TipTags(
    val tags:List<String>
)