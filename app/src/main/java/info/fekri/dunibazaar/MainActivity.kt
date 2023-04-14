package info.fekri.dunibazaar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import info.fekri.dunibazaar.theme.MainAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainAppTheme {
                DuniBazaarUi()
            }
        }
    }
}

@Composable
fun DuniBazaarUi() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "main_screen"
    ) {

        composable("main_screen") {
            MainScreen()
        }

        composable(
            route = "product_screen/{product_id}",
            arguments = listOf(navArgument("product_id") { type = NavType.IntType })
        ) {
            ProductScreen(it.arguments!!.getInt("product_id", -1))
        }

        composable(
            route = "category_screen",
            arguments = listOf(navArgument("category_name") { type = NavType.StringType })
        ) {
            CategoryScreen(it.arguments!!.getString("category_name", "null"))
        }

        composable("profile_screen") {
            ProfileScreen()
        }

        composable("cart_screen") {
            CartScreen()
        }

        composable("sing_up_screen") {
            SignUpScreen()
        }

        composable("sign_in_screen") {
            SignInScreen()
        }

        composable("intro_screen") {
            IntroScreen()
        }

        composable("no_internet_screen") {
            NoInternetScreen()
        }

    }
}

@Composable
fun NoInternetScreen() {

}

@Composable
fun IntroScreen() {

}

@Composable
fun CartScreen() {

}

@Composable
fun SignUpScreen() {

}

@Composable
fun SignInScreen() {

}

@Composable
fun ProfileScreen() {

}

@Composable
fun CategoryScreen(categoryName: String) {

}

@Composable
fun ProductScreen(productId: Int) {

}

@Composable
fun MainScreen() {

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainAppTheme {
        DuniBazaarUi()
    }
}