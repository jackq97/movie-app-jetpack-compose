package com.example.jetmovieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetmovieapp.navigation.MovieNavigation
import com.example.jetmovieapp.ui.theme.JetMovieAppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // first passing ur my app function and inside it
            // all the composable function we are going to make
            MyApp {
                MovieNavigation()
            }
        }
    }
}

// our container function, i need more info about this one
// it allows us call our function MyApp and pass any composable
// function inside it.

@Composable
fun MyApp(content: @Composable () -> Unit) {
    // now inside this function we gonna get all the stuff from set content
    // and paste it here

    // to change system ui status bar color
    val systemUiController = rememberSystemUiController()

    JetMovieAppTheme {
        systemUiController.setSystemBarsColor(color = Color.LightGray)

        // calling the content so we can have what
        // we put inside the MyApp composable
        content()
    }
}

// now this function is kinda like layout list from recycler view
// it has a card and we can pass our movie String as a parameter inside
// this composable 

// as we know there are two ways we can utilise onClick method
// we can define it and pass our code directly into
// or we can make a trailing function that the onClick method
// will invoke

@Preview
@Composable
fun MovieRow(movieName: String = "jassi",
 onItemClick: (String) -> Unit = {}  ) {
    
    Card(modifier = Modifier
        .padding(12.dp)
        .fillMaxWidth()
        .height(130.dp)
        .clickable {
            // invoke our trailing lambda function here
            // and pass the movie name in it
            onItemClick(movieName)
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
                Icon(imageVector = Icons.Default
                    .AccountBox,
                    tint = Color.LightGray,
                    contentDescription = "movie")
            }

            Text(

                text = movieName,
                style = TextStyle(
                )

            )

        }



    }
    
}

// now we also transform this preview like we transformed our set content
// for our preview, so we can see what's exactly is up with our code

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MovieNavigation()
    }
}