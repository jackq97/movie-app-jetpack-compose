package com.example.jetmovieapp.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.jetmovieapp.R
import com.example.jetmovieapp.model.Movie
import com.example.jetmovieapp.model.getMovie
import com.example.jetmovieapp.navigation.MovieScreens
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

// here we gonna add details screen for our app
// this file is inside a package named details
// the second parameter is data that we are passing from the
// home screen

@Preview
@Composable
fun DetailsScreen(navController: NavController = rememberNavController(),
                  movieData: String? = getMovie()[0].id){

    val movieDetails = getMovie()
    val movieInfoFromId = movieDetails.single { item ->
        item.id == movieData
    }

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = colorResource(id = R.color.nordic_dark),
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
                            tint = Color.Black,
                            )
                    }

                    Text(
                        modifier = Modifier.padding(start = 10.dp),
                        text = "Movie details",
                        fontSize = 22.sp,

                    )
                }
            }
        })
    {

        Surface(modifier = Modifier.fillMaxSize(),
            color = colorResource(id = R.color.nordic_dark)
        ) {

            Surface(modifier = Modifier.fillMaxSize(),
                shape = RoundedCornerShape(topStart = 14.dp,
                    topEnd = 14.dp),
                color = colorResource(id = R.color.nordic_less_dark)
            ) {

                Column(modifier = Modifier.padding(12.dp)) {

                    HorizontalImagesLazyRow(movieInfoFromId){ imageUrl ->

                        /**
                         found fix for app crashing while passing in the
                         image url through the navigation. the thing is
                         you first gotta encode the link before passing it
                         in the navigation component.
                         */

                       val url = URLEncoder.encode(imageUrl, StandardCharsets.UTF_8.toString())

                        // TODO: change activity and pass the image url in here

                        // now we gonna pass the single movie name in
                        // our screen directory

                        navController.navigate(
                            route = MovieScreens
                                .ImageDetailsScreen
                                .name+"/$url")
                    }

                    Divider()

                    Row(modifier = Modifier.width(355.dp),
                        horizontalArrangement = Arrangement.End
                    ) {

                        Text(//modifier = Modifier.width(280.dp),
                            modifier = Modifier.weight(3f),
                            text = movieInfoFromId.title,
                            style = MaterialTheme.typography.h3,
                            color = Color.White
                        )

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .height(60.dp),
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.End
                        ) {

                            Text(modifier = Modifier.padding(bottom = 3.dp),
                                text = "${movieInfoFromId.rating}/10",
                                fontSize = 22.sp
                            )

                            Text(
                                text = movieInfoFromId.year,
                                modifier = Modifier
                                  //  .weight(1f)
                            )

                        }



                    }

                    Text(text = movieInfoFromId.genre,
                        style = MaterialTheme.typography.subtitle1,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(bottom = 10.dp)
                        )

                    Text(text = movieInfoFromId.director,
                        style = MaterialTheme.typography.subtitle2,
                                fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                        )

                    Text(text = movieInfoFromId.actors,
                        style = MaterialTheme.typography.body2,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                        )

                    Text(text = movieInfoFromId.plot,
                            style = MaterialTheme.typography.body1,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )









                }
            }
        }
    }
}

@Composable
private fun HorizontalImagesLazyRow(movieInfoFromId: Movie,
onclickAction: (String) -> Unit) {
    LazyRow {

        items(items = movieInfoFromId.images) { image ->

            Image(
                painter = rememberAsyncImagePainter(model = image),
                contentDescription = "movie image",
                modifier = Modifier
                    .clickable {
                        onclickAction(image)
                    }
                    .height(200.dp)
                    .width(290.dp)
                    .padding(
                        all = 10.dp
                    )
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.FillBounds,
            )
        }
    }
}