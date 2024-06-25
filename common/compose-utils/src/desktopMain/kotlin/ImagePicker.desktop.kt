import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darkrockstudios.libraries.mpfilepicker.FilePicker
import com.darkrockstudios.libraries.mpfilepicker.MPFile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
actual fun ImagePicker(
    modifier: Modifier,
    onImagePicked: (ByteArray) -> Unit,
) {

    var pickerActive by remember {
        mutableStateOf(false)
    }
    val bytesState = remember {
        mutableStateOf<ByteArray?>(null)
    }
    val imageState = rememberBitmapFromBytes(bytesState.value)

    val fileType = listOf("jpg", "png")
    fun imageHandler(file: MPFile<Any>){
        CoroutineScope(Dispatchers.IO).launch {
            val bytes = file.getFileByteArray()
            file.path
            onImagePicked(bytes)
            bytesState.value = bytes
        }
    }

    FilePicker(show = pickerActive, fileExtensions = fileType) { platformFile ->
        if(platformFile != null){
            imageHandler(platformFile)
            pickerActive = false
        }
    }
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        onClick = {
            pickerActive = true
        }
    ) {
        Box(
            modifier = modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(vertical = 28.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                if(imageState == null){
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
            if(imageState != null){
                Image(
                    bitmap = imageState,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }

}