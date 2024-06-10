import models.Tip

interface TipsRepository {
    suspend fun fetchTips(refresh:Boolean, limit:Int, offset:Int):List<Tip>
    suspend fun deleteTip(id:String)
    suspend fun insertTip(tip: Tip):String
    suspend fun fetchTip(id:String):Tip
    suspend fun editTip(tip: Tip)

}