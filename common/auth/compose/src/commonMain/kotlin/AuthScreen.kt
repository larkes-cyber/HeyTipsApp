import NavigationTree
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable


@Composable
fun AuthScreen(
    component: AuthScreenComponent
) {
    Column {
        Button(
            onClick = {
                component.adminNavigate()
            }
        ){
            Text("Admin")
        }
        Button(
            onClick = {
                component.userNavigate()
            }
        ){
            Text("User")
        }
    }
}