import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import models.AuthEvent


@Composable
fun AuthScreen(
    component: AuthComponent
) {
    Column {
        Button(
            onClick = {
                component.obtainEvent(AuthEvent.AdminClicked)
            }
        ){
            Text("Admin")
        }
        Button(
            onClick = {
                component.obtainEvent(AuthEvent.UserClicked)
            }
        ){
            Text("User")
        }
    }
}