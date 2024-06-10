import models.AdminTip
import models.AdminTipTags
import models.Tip
import models.TipTags

class AdminRepositoryImpl(
    private val tipsRepository: TipsRepository
):AdminRepository {
    override suspend fun addTip(adminTip: AdminTip) {
        tipsRepository.insertTip(adminTip.toTip())
    }

    override suspend fun fetchTips(refresh: Boolean, limit: Int, offset: Int):List<AdminTip> {
        return tipsRepository.fetchTips(refresh = refresh, limit = limit, offset = offset).map { it.toAdminTags() }
    }

    override suspend fun fetchTip(id: String):AdminTip {
        return tipsRepository.fetchTip(id).toAdminTags()
    }

    override suspend fun deleteTip(id: String) {
        tipsRepository.deleteTip(id)
    }
}

fun AdminTip.toTip(): Tip {
    return Tip(
        id = id,
        title = title,
        description = description,
        imageSrc = imageSrc,
        tags = if(tags != null) TipTags(tags!!.tags) else null,
        color = color,
        serverId = serverId
    )
}

fun Tip.toAdminTags():AdminTip{
    return AdminTip(
        id = id,
        title = title,
        description = description,
        imageSrc = imageSrc,
        tags = if(tags != null) AdminTipTags(tags!!.tags) else null,
        color = color,
        serverId = serverId
    )
}