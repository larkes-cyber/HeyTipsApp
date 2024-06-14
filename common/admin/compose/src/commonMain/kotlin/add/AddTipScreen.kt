package add

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eygraber.compose.colorpicker.ColorPicker

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AddTipScreen(
    addTipComponent: AddTipComponent
) {

    val textField = remember {
        mutableStateOf("")
    }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 20.dp)
            .padding(horizontal = 15.dp)
            .verticalScroll(scrollState)
    ) {
        Box {
            Text(text = "HeyTips",
                fontSize = 28.sp,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
            Box(){
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier.size(35.dp).clickable {
                        addTipComponent.goBack()
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth().height(210.dp), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Card(
                modifier = Modifier.weight(0.42f),
                shape = RoundedCornerShape(12.dp),
                onClick = {

                }
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(vertical = 28.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Select tip photo",
                        fontSize = 24.sp,
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center
                    )
                    Icon(
                        imageVector = Icons.Outlined.Face,
                        contentDescription = null,
                        modifier = Modifier.size(70.dp)
                    )

                }
            }
            Column(
                modifier = Modifier.weight(0.58f).fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    label = {
                            Text("Enter title")
                    },
                    onValueChange = {

                    },
                    value = textField.value,
                    modifier = Modifier.padding(vertical = 0.dp)
                )
                Column {
                    Text(text = "Chose tag",
                        fontSize = 22.sp,
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(14.dp))
                    LazyVerticalGrid(
                        modifier = Modifier.fillMaxWidth(),
                        columns = GridCells.Fixed(3),
                        horizontalArrangement = Arrangement.spacedBy(3.dp),
                        verticalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        items(Tags.entries){
                            Box(
                                modifier = Modifier
                                    .height(40.dp)
                                    .border(border = BorderStroke(1.dp, Color.Black.copy(alpha = 0.12f)), shape = RoundedCornerShape(10.dp))
                                    .clickable {  },
                                contentAlignment = Alignment.Center
                            ){
                                Text(
                                    it.name,
                                    fontSize = 18.sp,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(22.dp))
        Text(text = "Description",
            fontSize = 24.sp,
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.Medium
        )
        OutlinedTextField(
            label = {
                Text("Enter text here...")
            },
            onValueChange = {

            },
            value = textField.value,
            modifier = Modifier.defaultMinSize(minHeight = 150.dp).fillMaxWidth().padding(vertical = 0.dp)
        )
        Spacer(modifier = Modifier.height(22.dp))
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Select color",
                fontSize = 24.sp,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(15.dp))
            ColorPicker(
                modifier = Modifier.size(210.dp)
            ) {

            }
        }
        Spacer(modifier = Modifier.height(22.dp))
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth().height(70.dp),
            shape = RoundedCornerShape(10.dp)
        ){
            Text(text = "Add Tip!",
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(35.dp))
    }
}