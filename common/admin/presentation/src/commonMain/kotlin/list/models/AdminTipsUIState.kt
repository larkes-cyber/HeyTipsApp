package list.models

import models.AdminTip

data class AdminTipsUIState(
    val list:List<AdminTip> = listOf(),
    val offset:Int = 1
)