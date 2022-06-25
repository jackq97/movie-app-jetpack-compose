package com.example.jetmovieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetmovieapp.screens.home.HomeScreen

// setting up our main navigation controller
// for that we gon make a composable function first


@Composable
fun MovieNavigation() {

    val navController = rememberNavController()

    // now inside it we gonna have nav host and in it
    // we gonna pass the nav controller and start destination of our app
    // which is going to be the home screen 
    
    NavHost(navController = navController,
        startDestination = MovieScreens.HomeScreen.name) {

        // since our screens will be composable we gonna call this
        // composable function inside the nav host
        // and define the route "String" (Name) of our screen
        // and inside it we gonna pass the screen

        composable(MovieScreens.HomeScreen.name) {
            // here we pass where this should lead to
            HomeScreen(navController = navController)
        }
    }
}