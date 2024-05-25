package com.example.lampshop_kotlin.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.lampshop_kotlin.ui.screens.auth.login.LoginScreen
import com.example.lampshop_kotlin.ui.screens.auth.signup.SignUpScreen
import com.example.lampshop_kotlin.ui.screens.main.MainScreen
import com.example.lampshop_kotlin.ui.screens.splash.StartScreen

sealed class Route{
    data class StartScreen(val name:String = "Start"): Route()
    data class LoginScreen(val name:String = "Login"): Route()
    data class SignupScreen(val name:String = "Signup"): Route()
    data class MainScreen(val name:String = "Main"): Route()
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
                            Route.MainScreen().name
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
                            Route.MainScreen().name
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
        composable(route = Route.MainScreen().name){
            MainScreen()
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