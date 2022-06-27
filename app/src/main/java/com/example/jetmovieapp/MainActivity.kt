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
import com.example.jetmovieapp.model.Movie
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

// now we also transform this preview like we transformed our set content
// for our preview, so we can see what's exactly is up with our code

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MovieNavigation()
    }
}