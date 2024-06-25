package database

import org.larkes.contacts.database.TipEntity
import org.larkes.heytips.TipsDatabase


class TipsSqlDelightDataSource(
    private val db:TipsDatabase
) {

    private val queries = db.tipsQueries

    suspend fun insertTip(tipEntity: TipEntity){
        queries.insertTip(
            id = tipEntity.id,
            description =  tipEntity.description,
            color = tipEntity.color,
            imageSrc = tipEntity.imageSrc,
            tags = tipEntity.tags,
            title = tipEntity.title,
            serverId = tipEntity.serverId
        )
    }

    suspend fun deleteTip(id:String){
        queries.deleteTip(id)
    }

    fun fetchTips():List<TipEntity>{
        return queries.fetchTips().executeAsList()
    }

    suspend fun clearTips(){
        queries.clearStorage()
    }

    fun fetchTip(id:String):TipEntity{
        return queries.fetchTip(id).executeAsOne()
    }

}