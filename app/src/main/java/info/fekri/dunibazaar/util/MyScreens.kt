package info.fekri.dunibazaar.util

sealed class MyScreens(val route: String) {
    object MainScreen: MyScreens("main_screen")
    object ProductScreen: MyScreens("product_screen")
    object CategoryScreen: MyScreens("category_screen")
    object ProfileScreen: MyScreens("profile_screen")
    object CartScreen: MyScreens("cart_screen")
    object SignUpScreen: MyScreens("sign_up_screen")
    object SignInScreen: MyScreens("sign_in_screen")
    object IntroScreen: MyScreens("intro_screen")
    object NoInternetScreen: MyScreens("no_internet_screen")
}
