package com.santoshpillai.gwatch.ui.home

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.santoshpillai.gwatch.ui.AppScaffold

@ExperimentalMaterialApi
@Composable
fun HomeScreen(
    vm: HomeScreenViewModel
){
    AppScaffold(
        currentSheet = "test"
    ) {
        Scaffold(
            topBar = {},
            bottomBar = {}

        ) {
            // Main Content

            Text("Time ${vm.watches}")

        }

    }
}