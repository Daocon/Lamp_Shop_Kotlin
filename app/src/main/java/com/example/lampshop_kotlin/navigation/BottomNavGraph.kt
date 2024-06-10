package com.example.lampshop_kotlin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lampshop_kotlin.ui.screens.cart.CartScreen
import com.example.lampshop_kotlin.ui.screens.checkout.CheckOutScreen
import com.example.lampshop_kotlin.ui.screens.detail.DetailScreen
import com.example.lampshop_kotlin.ui.screens.favorite.FavoriteScreen
import com.example.lampshop_kotlin.ui.screens.home.HomeScreen
import com.example.lampshop_kotlin.ui.screens.notification.NotificationScreen
import com.example.lampshop_kotlin.ui.screens.profile.ProfileScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route){
            HomeScreen(navController)
        }
        composable(route = BottomBarScreen.Favorite.route){
            FavoriteScreen()
        }
        composable(route = BottomBarScreen.CheckOut.route){
            CheckOutScreen(navController)
        }
        composable(route = BottomBarScreen.Profile.route){
            ProfileScreen()
        }
        composable(route = BottomBarScreen.Detail.route + "/{lampId}") { backStackEntry ->
            val lampId = backStackEntry.arguments?.getString("lampId")
            DetailScreen(navController = navController, lampId = lampId)
        }

    }
}