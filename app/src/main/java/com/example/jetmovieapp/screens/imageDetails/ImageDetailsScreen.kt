package com.example.jetmovieapp.screens.imageDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter

@Composable
fun ImageDetailsScreen(navController: NavController,
                       image: String?) {
    Surface(modifier = Modifier.fillMaxSize(),
        color = Color.Black.copy(alpha = 0.8f),
    ) {

        Image(painter = rememberAsyncImagePainter(model = image),
            contentDescription = "selected movie image")

    }
}