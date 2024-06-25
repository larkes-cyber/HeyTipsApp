package views

import Constants
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage


@Composable
fun TipView(
    modifier: Modifier = Modifier,
    title:String,
    description:String,
    imageSrc:String? = null,
    tags:List<String> = listOf(),
    color:Long? = null
) {

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(7)
    ) {
        Box(modifier = Modifier.fillMaxSize().background(if(color == null) Color.White else Color(color.toULong()).copy(alpha = 0.24f))){
            Row(
                modifier = Modifier.fillMaxSize().padding(vertical = 15.dp, horizontal = 18.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                if(imageSrc != null) {
                    AsyncImage(
                        modifier = modifier.weight(0.3f).height(160.dp).clip(RoundedCornerShape(10)),
                        model = "${Constants.SERVER_URL}/tips/image/get?id=$imageSrc",
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.weight(0.05f))
                }
                Column(
                    modifier =if(imageSrc == null) Modifier.weight(0.65f) else Modifier.weight(0.65f).heightIn(min = 125.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text(
                            text = title.toUpperCase(),
                            fontSize = 18.sp,
                            color = Color(0xff2B2B2B),
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = if(description.length > 140) description.substring(0, 138)  else description,
                            fontSize = 13.sp,
                            color = Color(0xff2B2B2B),
                            fontWeight = FontWeight.Medium
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                    }
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(3),
                        modifier = Modifier.heightIn(max = 200.dp),
                        horizontalArrangement = Arrangement.spacedBy(3.dp),
                        verticalArrangement = Arrangement.spacedBy(3.dp)
                    ){
                        items(tags, {it}){
                            Box(
                                modifier = Modifier
                                    .border(border = BorderStroke(1.dp, Color.Black), shape =  RoundedCornerShape(60)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    it,
                                    fontSize = 12.sp,
                                    color = Color(0xff2B2B2B),
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier.padding(vertical = 4.dp, horizontal = 10.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }

}