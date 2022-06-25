package com.example.jetmovieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetmovieapp.screens.homes.HomeScreen
import com.example.jetmovieapp.screens.details.DetailsScreen

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

        // this is where we put all of the screens
        // we gotta put all the screens in their own composable function

        // passing data in the screens as an argument
        // this composable function has an parameter that
        // accepts list of arguments and in it we can pass the name
        // and type of argument

        composable(MovieScreens.DetailsScreen.name
        , arguments = listOf(navArgument(name = "movie"){type = NavType.StringType})
        ) {

            // so we are putting the data as an argument but how do we get
            // access to or retrieve the data, well we gonna get it from
            // the nav back stack entry which is lambda function containing
            // the data, then we can pass in inside our details screen as a
            // parameter

                DetailsScreen(navController = navController
                ,
                )
        }

    }
}