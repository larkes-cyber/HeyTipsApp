package ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.http.path
import ktor.models.AddTipRequest
import ktor.models.AddTipResponse
import ktor.models.DeleteTipRequest
import ktor.models.TipResponse

class TipsKtorDataSource(
    private val httpClient:HttpClient
) {

    suspend fun insertTip(addTipRequest: AddTipRequest):AddTipResponse{
        val res = httpClient.post {
            contentType(ContentType.Application.Json)

            url{
                path(INSERT_TIP)
            }
            setBody(addTipRequest)
        }
        if(res.status != HttpStatusCode.OK){
            throw Error(res.status.description)
        }
        return res.body()
    }

    suspend fun fetchTips():List<TipResponse>{
        val res = httpClient.get {
            contentType(ContentType.Application.Json)
            url{
                path(FETCH_TIPS)
            }
        }
        if(res.status != HttpStatusCode.OK){
            throw Error(res.status.description)
        }
        return res.body()
    }

    suspend fun deleteTip(deleteTipRequest: DeleteTipRequest){
        val res = httpClient.post {
            contentType(ContentType.Application.Json)
            url{
                path(DELETE_TIP)
            }
            setBody(deleteTipRequest)
        }
        if(res.status != HttpStatusCode.OK){
            throw Error(res.status.description)
        }
    }

    companion object{

        private const val INSERT_TIP = "insertTip"
        private const val FETCH_TIPS = "fetchTips"
        private const val DELETE_TIP = "deleteTip"

    }

}