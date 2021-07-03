package com.santoshpillai.gwatch.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope


@ExperimentalMaterialApi
@Composable
fun AppScaffold(
    currentSheet: String,
    content: @Composable (PaddingValues) -> Unit
){
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()
    
    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = { /*TODO*/ },
        content = content
    )

}