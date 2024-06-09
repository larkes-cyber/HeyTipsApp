package ktor.models

import kotlinx.serialization.Serializable

@Serializable
data class FetchTipQuery(
    val id:String
)