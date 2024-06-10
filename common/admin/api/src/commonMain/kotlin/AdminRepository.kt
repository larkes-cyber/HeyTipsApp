import models.AdminTip

interface AdminRepository {
    suspend fun addTip(adminTip: AdminTip)
    suspend fun fetchTips(refresh:Boolean, limit:Int, offset:Int):List<AdminTip>
    suspend fun fetchTip(id:String):AdminTip
    suspend fun deleteTip(id:String)

}