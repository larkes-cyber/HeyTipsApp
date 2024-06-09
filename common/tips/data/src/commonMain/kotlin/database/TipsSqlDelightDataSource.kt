package database

import kotlinx.serialization.json.Json
import models.TipTags
import org.larkes.contacts.TipsDatabase
import org.larkes.contacts.database.TipEntity


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

    suspend fun fetchTips():List<TipEntity>{
        return queries.fetchTips().executeAsList()
    }

    suspend fun clearTips(){
        queries.clearStorage()
    }

    suspend fun fetchTip(id:String):TipEntity{
        return queries.fetchTip(id).executeAsOne()
    }

}