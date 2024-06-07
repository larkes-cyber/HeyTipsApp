package ktor.models

import kotlinx.serialization.Serializable

@Serializable
data class DeleteTipRequest(
    val id:String
)