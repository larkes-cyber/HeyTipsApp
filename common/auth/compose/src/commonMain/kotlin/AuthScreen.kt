import NavigationTree
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.Navigation

@Composable
fun AuthScreen(navController: NavController) {
    Column {
        Button(
            onClick = {
                navController.navigate(NavigationTree.Admin.TipsList.name)
            }
        ){
            Text("Admin")
        }
        Button(
            onClick = {
                navController.navigate(NavigationTree.User.TipsList.name)
            }
        ){
            Text("User")
        }
    }
}