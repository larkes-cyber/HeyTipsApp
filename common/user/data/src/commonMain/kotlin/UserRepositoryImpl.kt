import models.Tip
import models.UserTip
import models.UserTipTags

class UserRepositoryImpl(
    private val tipsRepository: TipsRepository
):UserRepository {
    override suspend fun fetchTips(refresh:Boolean, limit:Int, offset:Int): List<UserTip> {
        return tipsRepository.fetchTips(refresh = refresh, limit = limit, offset = offset).map { it.toUserTip() }
    }

    override suspend fun fetchTipDetail(id: String):UserTip {
        return tipsRepository.fetchTip(id).toUserTip()
    }
}

fun Tip.toUserTip():UserTip{
    return UserTip(
        id = id,
        title = title,
        description = description,
        imageSrc = imageSrc,
        tags = if(tags != null) UserTipTags(tags!!.tags) else null,
        color = color,
        serverId = serverId
    )
}