import database.TipsSqlDelightDataSource
import ktor.TipsKtorDataSource
import ktor.models.DeleteTipRequest
import ktor.models.FetchTipsQuery
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
            }.subList(offset, limit)
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
        tipsSqlDelightDataSource.deleteTip(id)
        tipsKtorDataSource.deleteTip(DeleteTipRequest(id))
    }

    override suspend fun insertTip(tip: Tip) {
        val id = randomUUID()
        tipsSqlDelightDataSource.insertTip(tip.toTipEntity(id))
    }
}