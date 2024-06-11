package com.example.lampshop_kotlin.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )
    object Favorite : BottomBarScreen(
        route = "favorite",
        title = "Favorite",
        icon = Icons.Default.Favorite
    )
    object Notify : BottomBarScreen(
        route = "notify",
        title = "Notify",
        icon = Icons.Default.Notifications
    )
    object Profile : BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
    object Detail : BottomBarScreen(
        route = "detail",
        title = "Detail",
        icon = Icons.Default.Info
    )
    object Cart : BottomBarScreen(
        route = "cart",
        title = "Cart",
        icon = Icons.Default.ShoppingCart
    )

    object CheckOut : BottomBarScreen(
        route = "checkout",
        title = "CheckOut",
        icon = Icons.Default.ShoppingCart
    )
}