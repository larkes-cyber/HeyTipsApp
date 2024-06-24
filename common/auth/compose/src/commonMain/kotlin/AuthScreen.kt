import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import models.AuthEvent


@Composable
fun AuthScreen(
    component: AuthComponent
) {
    Box(modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp), contentAlignment = Alignment.Center) {
        Column {
            Text("Select role", style = MaterialTheme.typography.h4)
            Spacer(modifier = Modifier.height(25.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ){
                Button(
                    onClick = {
                        component.obtainEvent(AuthEvent.AdminClicked)
                    },
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    shape = RoundedCornerShape(10.dp)
                ){
                    Text("Admin")
                }
                Button(
                    onClick = {
                        component.obtainEvent(AuthEvent.UserClicked)
                    },
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    shape = RoundedCornerShape(10.dp)
                ){
                    Text("User")
                }
            }
        }
    }

}