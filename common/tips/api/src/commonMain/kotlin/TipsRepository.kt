import models.Tip

interface TipsRepository {
    suspend fun fetchTips():List<Tip>
    suspend fun deleteTip(id:String)
    suspend fun insertTip(tip: Tip)

}