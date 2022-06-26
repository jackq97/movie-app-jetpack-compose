package com.example.jetmovieapp.screens.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.navigation.NavController

// here we gonna add details screen for our app
// this file is inside a package named details
// the second parameter is data that we are passing from the
// home screen

@Composable
fun DetailsScreen(navController: NavController,
                  movieData: String?){

    Surface(modifier = Modifier.fillMaxSize()) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = movieData.toString(),
                style = MaterialTheme.typography.h6
            )

            Button(onClick = {

                // going back to the activity we came from
                navController.popBackStack()

            }) {

                Text(text = "GO BACK",
                    style = MaterialTheme.typography.button
                )

            }

        }

    }



}