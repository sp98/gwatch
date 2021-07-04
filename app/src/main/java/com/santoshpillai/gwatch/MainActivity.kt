package com.santoshpillai.gwatch

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.santoshpillai.gwatch.ui.NavGraph
import com.santoshpillai.gwatch.ui.home.HomeScreenViewModel
import com.santoshpillai.gwatch.ui.theme.GWatchTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val homeScreenVM by viewModels<HomeScreenViewModel>()
        setContent {
            GWatchTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    GWatchApp(
                        homeScreenVM
                    )
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun GWatchApp(
    homeScreenVm: HomeScreenViewModel
){
    NavGraph(
        homeScreenVm = homeScreenVm
    )
}
