import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import tips_list.AdminTipsScreen
import tips_list.UserTipsScreen

@Composable
fun Navigation(navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination =NavigationTree.Auth.Auth.name){
        composable(route = NavigationTree.User.TipsList.name){
            UserTipsScreen(navHostController)
        }
        composable(route = NavigationTree.Admin.TipsList.name){
            AdminTipsScreen(navHostController)
        }
        composable(route = NavigationTree.Auth.Auth.name){
            AuthScreen(navHostController)
        }
    }

}