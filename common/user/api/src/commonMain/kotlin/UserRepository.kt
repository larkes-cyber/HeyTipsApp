import models.UserTip

interface UserRepository {
    suspend fun fetchTips(refresh:Boolean, limit:Int, offset:Int):List<UserTip>
    suspend fun fetchTipDetail(id:String):UserTip
}