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
import uuid.randomUUID

class TipsRepositoryImpl(
    private val tipsSqlDelightDataSource: TipsSqlDelightDataSource,
    private val tipsKtorDataSource: TipsKtorDataSource
):TipsRepository {
    override suspend fun fetchTips(refresh:Boolean, limit:Int, offset:Int): List<Tip> {
        val cachedTips = tipsSqlDelightDataSource.fetchTips()
        return if(cachedTips.size >= offset+limit && refresh.not()){
            cachedTips.map {
                it.toTip()
            }.subList(offset-1, offset + limit - 1)
        }else{
            tipsSqlDelightDataSource.clearTips()
            val serverTips = tipsKtorDataSource.fetchTips(FetchTipsQuery(limit = limit, offset = offset))
            val tips = serverTips.map {
                val id = randomUUID()
                tipsSqlDelightDataSource.insertTip(it.toTipEntity(id))
                it.toTip(id)
            }
            tips
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
}