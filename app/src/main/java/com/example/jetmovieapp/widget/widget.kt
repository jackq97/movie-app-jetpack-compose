package com.example.jetmovieapp.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.jetmovieapp.model.Movie
import com.example.jetmovieapp.model.getMovie

// here we pass the composable ui elements

// now this function is kinda like layout list from recycler view
// it has a card and we can pass our movie String as a parameter inside
// this composable

// as we know there are two ways we can utilise onClick method
// we can define it and pass our code directly into
// or we can make a trailing function that the onClick method
// will invoke

@Preview
@Composable
// the movie name expects a string, for that we gonna
// pass our Movie data object that contains all the info
// and all the info is in form of string

fun MovieRow(movie: Movie = getMovie()[0],
             onItemClick: (String) -> Unit = {}  ) {

    Card(modifier = Modifier
        .padding(12.dp)
        .fillMaxWidth()
        .height(130.dp)
        .clickable {
            // invoke our trailing lambda function here
            // and pass the id from the Movie object
            // so later we can retrieve all the info
            // connected to that id
            onItemClick(movie.id)
        },
        elevation = 4.dp,
        backgroundColor = MaterialTheme.colors.background
    ) {

        // now to add multiple elements inside our list
        // and to also manage text's position in card
        // we gonna use row for that

        Row(
            // remember jassi vertical alignment and horizontal arrangement
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

            Surface(
                shape = RectangleShape,
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp)
            ) {
                
                Image(painter = rememberAsyncImagePainter(model = movie.images[0]),
                    contentDescription = "Movie Image")
                
            }
            
            Column() {

                Text(
                    // now here we gonna show the title
                    text = movie.title,
                    style = MaterialTheme.typography.h5
                )

                Text(
                    // now here we gonna show the title
                    text = "Director: ${movie.director}",
                    style = MaterialTheme.typography.subtitle2
                )

                Text(
                    // now here we gonna show the title
                    text = movie.year,
                    style = MaterialTheme.typography.caption
                )

            }



        }



    }

}
