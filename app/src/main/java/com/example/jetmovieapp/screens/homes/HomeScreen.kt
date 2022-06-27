package com.example.jetmovieapp.screens.homes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetmovieapp.model.Movie
import com.example.jetmovieapp.model.getMovie
import com.example.jetmovieapp.navigation.MovieScreens
import com.example.jetmovieapp.widget.MovieRow

// this seems like our homeScreen activity with the navController as it's parameter
// the reason why we are not passing inside the scaffold because it is already inside
// the HomeScreen

@Composable
fun HomeScreen(navController: NavController) {

    // scaffold to build basic structure and toolbar
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.LightGray
            ) {
                Text(
                    modifier = Modifier.padding(start = 10.dp),
                    text = "Movies",
                    fontSize = 22.sp
                )
            }
        }
    ) {
        // here we can pass the main content
        // and inside the main content we gonna pass
        // nav controller as a parameter

        // reason why we passed the nav controller inside this method
        // is because we can move to some other screen through this method
        MainContent(navController = navController)
    }
}


// this is our main content composable function
// inside it we gonna pass Surface too, to give our composable
// functions that we going to pass a background
// our to make a nice structure
// this function is outside the home screen

@Composable
        fun MainContent(
    // in here instead of hard coding the movie list we gonna pass the
    // Movie object type in list, and set it equal to our get movie
    navController: NavController,
    movieList: List<Movie> = getMovie()
        ) {

            // needs to be inside column since list will be stacked vertically

            Column(
                modifier = Modifier.padding(
                    start = 12.dp,
                    end = 12.dp,
                    bottom = 12.dp
                )
            ) {

                // lazy column demo
                // first starting with lazy column compose function

                LazyColumn() {

                    // inside it we gonna have items that is equal to the movie list
                    // and it is gonna return it as the trailing lambda, so we can
                    // perform operations on it

                    items(items = movieList) {

                        //Text(text = it)
                        // calling movie row function here items will iterate through
                        // all the available items and then add it to the card one by one

                        // we know movie row has a trailing lambda with movie parameter
                        MovieRow(it) { movieSingleItem ->

                            // now we gonna pass the single movie name in
                            // our screen directory

                            navController.navigate(
                                route = MovieScreens.DetailsScreen.name+"/$movieSingleItem")
                        }

                    }
                }
            }
        }

@Preview
@Composable
fun ShowPreview(){
    HomeScreen(navController = rememberNavController())
}