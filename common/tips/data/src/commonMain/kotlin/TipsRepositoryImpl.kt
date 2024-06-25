import database.TipsSqlDelightDataSource
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.plugins.HttpTimeout
import ktor.TipsKtorDataSource
import ktor.models.AddTipRequest
import ktor.models.DeleteTipRequest
import ktor.models.FetchTipQuery
import ktor.models.FetchTipsQuery
import mapper.toAddTipRequest
import mapper.toEditTipRequest
import mapper.toTip
import mapper.toTipEntity
import models.Tip
import org.larkes.contacts.database.TipEntity
import uuid.randomUUID

class TipsRepositoryImpl(
    private val tipsSqlDelightDataSource: TipsSqlDelightDataSource,
    private val tipsKtorDataSource: TipsKtorDataSource
):TipsRepository {
    override suspend fun fetchTips(refresh:Boolean, limit:Int, offset:Int): List<Tip> {
        val cachedTips = tipsSqlDelightDataSource.fetchTips()
        if(cachedTips.size >= offset && refresh.not()){
            return prepareCachedList(list = cachedTips, offset = offset, limit = limit)
        }else{
            return try {
                val serverTips = tipsKtorDataSource.fetchTips(FetchTipsQuery(limit = limit, offset = offset))
                if(refresh) tipsSqlDelightDataSource.clearTips()
                val tips = serverTips.map {
                    val id = randomUUID()
                    tipsSqlDelightDataSource.insertTip(it.toTipEntity(id))
                    it.toTip(id)
                }
                tips.reversed()
            }catch (e:Exception){
                prepareCachedList(list = cachedTips, offset = offset, limit = limit)
            }
        }
    }

    override suspend fun deleteTip(id: String) {
        val localTipServerId = tipsSqlDelightDataSource.fetchTip(id).serverId
        tipsSqlDelightDataSource.deleteTip(id)
        if(localTipServerId != null) tipsKtorDataSource.deleteTip(DeleteTipRequest(localTipServerId))
    }

    override suspend fun insertTip(tip: Tip):String {
        val id = randomUUID()
        try {
            val serverId = tipsKtorDataSource.insertTip(tip.toAddTipRequest())
            tip.serverId = serverId.serverId
        }catch (_:HttpRequestTimeoutException){
        }finally {
            tipsSqlDelightDataSource.insertTip(tip.toTipEntity(id))
        }
        return id
    }

    override suspend fun fetchTip(id: String):Tip {
        val localTip = tipsSqlDelightDataSource.fetchTip(id)
        return if(localTip.serverId != null){
            val serverTip = tipsKtorDataSource.fetchTip(FetchTipQuery(localTip.serverId!!))
            serverTip.toTip(id)
        }else{
            localTip.toTip()
        }

    }

    override suspend fun editTip(tip: Tip) {
        tipsSqlDelightDataSource.deleteTip(tip.id!!)
        tipsSqlDelightDataSource.insertTip(tip.toTipEntity(tip.id!!))
        if(tip.serverId != null){
            tipsKtorDataSource.editTip(tip.toEditTipRequest())
        }
    }

    override suspend fun uploadPhoto(byteArray: ByteArray): String {
        return tipsKtorDataSource.uploadPhoto(byteArray)
    }

    private fun prepareCachedList(list:List<TipEntity>, offset:Int, limit:Int):List<Tip>{

        if(offset > list.size) return emptyList()

        val finalLimit = if(limit + offset >= list.size) list.size else limit

        return list.map { it.toTip() }.subList(offset-1, offset + finalLimit - 1).reversed()
    }

}