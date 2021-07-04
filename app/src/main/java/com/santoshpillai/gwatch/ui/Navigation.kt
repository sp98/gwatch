package com.santoshpillai.gwatch.ui

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.santoshpillai.gwatch.ui.AppDestinations.CREATEWATCH
import com.santoshpillai.gwatch.ui.AppDestinations.HOMESCREEN
import com.santoshpillai.gwatch.ui.home.HomeScreen
import com.santoshpillai.gwatch.ui.home.HomeScreenViewModel

object AppDestinations{
    const val HOMESCREEN = "home"
    const val CREATEWATCH = "create"

}
class NavActions(private val navController: NavController) {

    val toHomeScreen = {
        navigateAndPopupToHome(HOMESCREEN)
    }

    val toCreateWatch = {
        navigateAndPopupToHome(CREATEWATCH)
    }

    // Navigate till `to` screen and pop up all the back stack entries up till home
    private fun navigateAndPopupToHome(to: String){
        navController.navigate(to){
            popUpTo(HOMESCREEN)
        }
    }

}


@ExperimentalMaterialApi
@Composable
fun NavGraph(
    homeScreenVm: HomeScreenViewModel
){
    val navController = rememberNavController()
    // TODO: Understand this line
    val navActions by remember { mutableStateOf(NavActions(navController = navController))}
    NavHost(navController = navController, startDestination = HOMESCREEN ) {
        composable(HOMESCREEN){
            HomeScreen(
                vm = homeScreenVm
            )
        }

        composable(CREATEWATCH){

        }

    }
}