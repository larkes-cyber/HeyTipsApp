package list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import list.models.AdminTipsEvent

@Composable
fun AdminTipsScreen(
    adminTipsComponent: AdminTipsComponent
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Box(
            modifier = Modifier.fillMaxWidth().padding(top = 15.dp, end = 20.dp)
        ) {
            Text(text = "HeyTips",
                fontSize = 28.sp,
                modifier = Modifier.align(Alignment.Center),
                fontWeight = FontWeight.Medium
            )
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                modifier = Modifier.size(32.dp).align(Alignment.CenterEnd).clickable {
                    adminTipsComponent.obtainEvent(AdminTipsEvent.AddIconClicked)
                }
            )
        }

    }
}