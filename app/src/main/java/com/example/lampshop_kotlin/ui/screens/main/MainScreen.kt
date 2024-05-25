package com.example.lampshop_kotlin.ui.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.lampshop_kotlin.navigation.BottomBarScreen
import com.example.lampshop_kotlin.navigation.BottomNavGraph

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) { paddingValues ->
        Box(Modifier.padding(paddingValues)) {
            BottomNavGraph(navController = navController)
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {

    var selectedScreen by remember { mutableStateOf(0) }

    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Detail,
        BottomBarScreen.Notify,
        BottomBarScreen.Profile
    )

    NavigationBar {
        screens.forEachIndexed { index, screen ->
            NavigationBarItem(
                selected = selectedScreen == index,
                onClick = {
                          navController.navigate(screen.route)
                    selectedScreen = index
                },
                icon = {
                    Icon(imageVector = screen.icon, contentDescription = "")
                },
                label = {
                    Text(text = screen.title)
                }
            )
        }
    }
}