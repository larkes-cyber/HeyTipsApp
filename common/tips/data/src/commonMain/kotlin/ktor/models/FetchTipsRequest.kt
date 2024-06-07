package ktor.models

data class FetchTipsQuery(
    val offset:Int,
    val limit:Int
)