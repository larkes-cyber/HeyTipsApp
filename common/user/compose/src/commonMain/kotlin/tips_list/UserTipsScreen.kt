package tips_list

import UserTipsScreenComponent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshContainer
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import models.UserTipsEvent
import views.TipView

@Composable
fun UserTipsScreen(
    userTipsScreenComponent: UserTipsScreenComponent
) {
    val tipsUIState by userTipsScreenComponent.tipsUIState.collectAsState()


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
        }

        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Button(
                onClick = {
                    userTipsScreenComponent.obtainEvent(UserTipsEvent.RefreshPulled)
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
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            itemsIndexed(tipsUIState.list){index, item ->
                TipView(
                    title = item.title,
                    description = item.description,
                    imageSrc = item.imageSrc,
                    color = item.color,
                    tags = item.tags?.tags ?: listOf()
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
            item{
                if(tipsUIState.loaderActive){
                    CircularProgressIndicator(
                        modifier = Modifier.onFocusEvent {
                            println("focused")
                            if(tipsUIState.isLoading.not()){
                                userTipsScreenComponent.obtainEvent(UserTipsEvent.ListEnded)
                            }
                        }
                    )
                }
            }
        }

    }
}