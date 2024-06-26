package ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.http.path
import ktor.models.AddTipRequest
import ktor.models.AddTipResponse
import ktor.models.DeleteTipRequest
import ktor.models.EditTipRequest
import ktor.models.FetchTipQuery
import ktor.models.FetchTipsQuery
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

    suspend fun fetchTips(fetchTipsQuery: FetchTipsQuery):List<TipResponse>{
        val res = httpClient.get {
            contentType(ContentType.Application.Json)
            url{
                parameter("offset", fetchTipsQuery.offset)
                parameter("limit", fetchTipsQuery.limit)
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

    suspend fun fetchTip(fetchTipQuery: FetchTipQuery):TipResponse{
        val res = httpClient.get {
            contentType(ContentType.Application.Json)
            url{
                parameter("id", fetchTipQuery.id)
                path(FETCH_ONE_TIP)
            }
        }
        if(res.status != HttpStatusCode.OK){
            throw Error(res.status.description)
        }
        return res.body()
    }

    suspend fun editTip(editTipRequest: EditTipRequest){
        val res = httpClient.post {
            contentType(ContentType.Application.Json)
            url{
                path(EDIT_TIP)
            }
            setBody(editTipRequest)
        }
        if(res.status != HttpStatusCode.OK){
            throw Error(res.status.description)
        }
    }

    suspend fun uploadPhoto(file:ByteArray):String{
        val response = httpClient.post(UPLOAD_TIP_IMAGE){
            setBody(
                MultiPartFormDataContent(
                    formData {
                        append("image", file, Headers.build {
                            append(HttpHeaders.ContentType, "image/png")
                            append(HttpHeaders.ContentDisposition, "filename=\"ktor_logo.png\"")
                        })
                    },
                    boundary = "WebAppBoundary"
                )
            )
        }
        if(response.status != HttpStatusCode.OK){
            throw Error(response.status.description)
        }
        return response.body()
    }

    companion object{
        private const val INSERT_TIP = "tips/add"
        private const val FETCH_TIPS = "tips/fetch"
        private const val DELETE_TIP = "tips/delete"
        private const val FETCH_ONE_TIP = "tips/fetchOne"
        private const val EDIT_TIP = "tips/edit"
        private const val UPLOAD_TIP_IMAGE = "tips/image/upload"

    }

}