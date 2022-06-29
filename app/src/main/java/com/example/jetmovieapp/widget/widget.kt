package com.example.jetmovieapp.widget

import android.graphics.Paint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.buildSpannedString
import coil.compose.rememberAsyncImagePainter
import com.example.jetmovieapp.R
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

fun MovieRow(
    movie: Movie = getMovie().first(),
    onItemClick: (String) -> Unit = {}) {

    // some constant values for our plot max and min lines
    // it will helps us expand the text

    val minimizedMaxLines = 1

    Card(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            // height needs to be dynamic, since we are using
            // expanded animation
            //.height(130.dp)
            .clickable {
                // invoke our trailing lambda function here
                // and pass the id from the Movie object
                // so later we can retrieve all the info
                // connected to that id
                onItemClick(movie.id)
            },
        elevation = 4.dp,
        backgroundColor = colorResource(id = R.color.nordic_little_dark)
    ) {

        // now to add multiple elements inside our list
        // and to also manage text's position in card
        // we gonna use row for that

        Row(
            // remember jassi vertical alignment and horizontal arrangement
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {

            Surface(
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(9.dp)
                    .size(100.dp)

            ) {

                Image(
                    painter = rememberAsyncImagePainter(movie.images.first()),
                    contentDescription = "Movie Image",
                    contentScale = ContentScale.Crop,
                )

            }

            Column(modifier = Modifier.padding(7.dp)){

                var isExpanded by remember { mutableStateOf(false) }

//                Row(verticalAlignment = Alignment.CenterVertically) {
//                Spacer(modifier = Modifier.width(80.dp))
//
//                  /*  Text(
//                        modifier = Modifier.width(80.dp),
//                        // now here we gonna show the title
//                        text = "Rating: ${movie.rating}",
//                        style = MaterialTheme.typography.caption
//                    )*/
//
//                }

                Row(verticalAlignment = Alignment.CenterVertically) {

                    Text(
                        // now here we gonna show the title
                        text = movie.title,
                        style = MaterialTheme.typography.h5,
                        modifier = Modifier.width(170.dp)
                    )
                    
                    Spacer(modifier = Modifier.width(10.dp))
                    
                    Text(
                        // now here we gonna show the title
                        text = "${movie.rating}/10",
                        fontSize = 16.sp,
                        modifier = Modifier.width(60.dp)

                    )

                }

                Text(
                    // now here we gonna show the title
                    text = "Director: ${movie.director}",
                    style = MaterialTheme.typography.subtitle2
                )

                Row(verticalAlignment = Alignment.CenterVertically) {

                    Text(
                        // now here we gonna show the title
                        text = movie.year,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier.width(100.dp)
                    )

                    Spacer(modifier = Modifier.width(110.dp))

                    Icon(
                        modifier = Modifier
                            .size(35.dp)
                            .clickable { isExpanded = !isExpanded },
                        imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp
                        else Icons.Filled.KeyboardArrowDown,
                        contentDescription = "expand Plot"
                    )


                }


                AnimatedVisibility(visible = isExpanded) {
                    Column(modifier = Modifier.width(180.dp)) {
                        // this is annotated string text composable function
                        // with the helps of this text field we can customise
                        // each word with different style
                        Text(
                            buildAnnotatedString {

                                withStyle(
                                    // span style means we are particularly changing
                                    // the style of string that we gonna append
                                    style = SpanStyle(
                                        color = colorResource(id = R.color.nordic_dark),
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.ExtraBold

                                    )
                                ) {
                                    // appending the string
                                    append("Plot: ")
                                }

                                withStyle(
                                    style = SpanStyle(
                                        color = colorResource(id = R.color.black),
                                        fontWeight = FontWeight.Light,
                                        fontSize = 12.sp
                                    )
                                ) {
                                    append(movie.plot)
                                }
                            }
                        )

                        Divider()

                        Text(text = "Actors : ${movie.actors}")


                    }
                }


            }
        }
    }
}
