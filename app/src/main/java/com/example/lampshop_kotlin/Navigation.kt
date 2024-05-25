package com.example.lampshop_kotlin

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.lampshop_kotlin.api.viewModel.LampViewModel
import com.example.lampshop_kotlin.ui.src.HomeScreen
import com.example.lampshop_kotlin.ui.src.StartScreen
import com.example.lampshop_kotlin.ui.login.LoginScreen
import com.example.lampshop_kotlin.ui.signup.SignUpScreen
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.asFlow

sealed class Route{
    data class StartScreen(val name:String = "Start"):Route()
    data class LoginScreen(val name:String = "Login"):Route()
    data class SignupScreen(val name:String = "Signup"):Route()
    data class HomeScreen(val name:String = "Home"):Route()
}

@Composable
fun MyNavigation(navHostController: NavHostController){

    var context = LocalContext.current

    NavHost(
        navController = navHostController,
        startDestination = "auth_flow"
    ) {
        navigation(startDestination = Route.StartScreen().name, route= "auth_flow"){
            composable(route = Route.LoginScreen().name){
                LoginScreen(
                    onLoginClick = {
                        navHostController.navigate(
                            Route.HomeScreen().name
                        ){
                            popUpTo(route = "auth_flow")
                        }
                    },
                    onSignUpClick = {
                        navHostController.navigateToSingleTop(
                            Route.SignupScreen().name
                        )
                    }
                )
            }
            composable(route = Route.StartScreen().name){
                StartScreen(
                    onStartClick = {
                        navHostController.navigateToSingleTop(
                            Route.LoginScreen().name
                        )
                    },
                )
            }
            composable(route = Route.SignupScreen().name){
                SignUpScreen(
                    onSignUpClick = {
                        navHostController.navigate(
                            Route.HomeScreen().name
                        ){
                            popUpTo(route= "auth_flow")
                        }
                    },
                    onLoginClick = {
                        navHostController.navigateToSingleTop(
                            Route.LoginScreen().name
                        )
                    }
                )
            }
        }
        composable(route = Route.HomeScreen().name){
            HomeScreen()
        }
    }
}

fun NavController.navigateToSingleTop(route: String){
    navigate(route){
        popUpTo(graph.findStartDestination().id){
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}