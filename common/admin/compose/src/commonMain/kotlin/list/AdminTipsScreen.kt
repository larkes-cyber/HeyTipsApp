package list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import list.models.AdminTipsEvent
import views.TipView

@Composable
fun AdminTipsScreen(
    adminTipsComponent: AdminTipsComponent
) {

    val tipsUIState by adminTipsComponent.tipsUIState.collectAsState()


    LaunchedEffect(Unit){
        adminTipsComponent.obtainEvent(AdminTipsEvent.ScreenOpened)
    }


    Column(
        modifier = Modifier.fillMaxSize().background(Color.White)
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

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Button(
                onClick = {
                    adminTipsComponent.obtainEvent(AdminTipsEvent.RefreshPulled)
                },
                modifier = Modifier.fillMaxWidth().height(42.dp),
                shape = RoundedCornerShape(25)
            ){
                Text("Refresh", color = Color.White)
            }
        }
        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
        ) {
            itemsIndexed(tipsUIState.list){index, item ->
                Box(
                    modifier = Modifier.fillMaxSize()
                ){
                    TipView(
                        title = item.title,
                        description = item.description,
                        imageSrc = item.imageSrc,
                        color = item.color,
                        tags = item.tags?.tags ?: listOf()
                    )
                    IconButton(
                        onClick = {
                            println("id_item: ${item.id}")
                            adminTipsComponent.obtainEvent(AdminTipsEvent.DeleteClicked(item.id ?: ""))
                        },
                        modifier = Modifier.align(Alignment.TopEnd)
                    ){
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = null,
                            tint = Color.Red.copy(alpha = 0.7f),
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
            item{
                if(tipsUIState.loaderActive){
                    CircularProgressIndicator(
                        modifier = Modifier.onFocusEvent {
                            println("focused")
                            if(tipsUIState.isLoading.not()){
                                adminTipsComponent.obtainEvent(AdminTipsEvent.ListEnded)
                            }
                        }
                    )
                }
            }
        }
    }
}