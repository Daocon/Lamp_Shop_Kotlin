package com.example.lampshop_kotlin.ui.src


import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lampshop_kotlin.api.model.Lamp
import com.example.lampshop_kotlin.api.viewModel.LampViewModel
import com.example.lampshop_kotlin.ui.components.LampsItems

@Composable
fun HomeScreen() {
    var context = LocalContext.current
    Text(text = "Home Screen", modifier = Modifier.padding(8.dp))

    val homeViewModel = viewModel(modelClass = LampViewModel::class.java)
    homeViewModel.getLampList()
    val lampList = homeViewModel.lampListResponse
    LampList(lampList)
    Log.d("HomeScreen", "HomeScreen" + lampList.size)

}

@Composable
fun LampList(lampList: List<Lamp>) {
    LazyColumn {
        itemsIndexed(items = lampList) { index, item ->
            LampsItems(lamp = item)
        }
    }
}