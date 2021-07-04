package com.santoshpillai.gwatch.ui.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@RequiresApi(Build.VERSION_CODES.O)
class HomeScreenViewModel : ViewModel() {

    private val watch1 = Watch(name = "India", zoneID = "Asia/Kolkata")
    private var allWatches = listOf(watch1)
    var watches by mutableStateOf("")

    init {
        viewModelScope.launch(Dispatchers.IO) {
            while (true) {
                delay(1000)
                watches = getCurrentTime("Asia/Kolkata")
            }
        }

    }

    private fun getCurrentTime(zoneID: String): String {
        val zonedDateTime = ZonedDateTime.now(ZoneId.of(zoneID))
        return zonedDateTime.format(
            DateTimeFormatter.ofLocalizedDateTime(
                FormatStyle.LONG,
                FormatStyle.SHORT
            )
        )
    }
}


data class Watch(
    val name: String,
    val zoneID: String,
    val format: String = "digital",
    var time: String = ""
)