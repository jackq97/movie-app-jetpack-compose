package com.example.jetmovieapp.screens.details

import android.graphics.Paint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetmovieapp.MyApp
import com.example.jetmovieapp.model.getMovie
import com.example.jetmovieapp.navigation.MovieNavigation

// here we gonna add details screen for our app
// this file is inside a package named details
// the second parameter is data that we are passing from the
// home screen


@Composable
fun DetailsScreen(navController: NavController,
                  movieData: String?){

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color(0xFF374758),
                elevation = 0.dp
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    IconButton(modifier = Modifier.size(50.dp),
                        onClick = {
                            // on click we gonna move back
                            navController.popBackStack()
                        }) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            "back button",
                            tint = Color.Black)
                    }

                    Text(
                        modifier = Modifier.padding(start = 10.dp),
                        text = "Movie details",
                        fontSize = 22.sp,

                    )
                }
            }
        }

    ) {

        Surface(modifier = Modifier.fillMaxSize(),
            color = Color(0xFF374758)
        ) {

            Surface(modifier = Modifier.fillMaxSize(),
                shape = RoundedCornerShape(topStart = 10.dp,
                    topEnd = 10.dp )
            ) {

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = movieData.toString(),
                        style = MaterialTheme.typography.h6
                    )

                    val movieDetails = getMovie()


                   val movieInfoFromId = movieDetails.single { item ->
                       item.id == movieData
                   }

                    Text(text = movieInfoFromId.title,
                        style = MaterialTheme.typography.h3
                    )
                }

            }

        }


    }
}

// using rememberNavController() in place of navigator controller
// to check the ui and so it doesn't give an error

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DetailsScreen(rememberNavController(), "movie")
}