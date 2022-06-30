package com.example.jetmovieapp.navigation


// it's like a directory home/documents/downloads

enum class MovieScreens {

    // enum class with our activities name objects

    HomeScreen,
    DetailsScreen,
    ImageDetailsScreen;


    // companion object for static functions
    companion object {

        // function taking a string route as parameter
        // and returning enum object

        fun fromRoute(route: String?): MovieScreens =

            // using when to check directory
            // using sub string to check what comes
            // after "/"
            when (route?.substringBefore("/")){

                // if it is home screen then we return the home Screen object

                HomeScreen.name -> HomeScreen
                DetailsScreen.name -> DetailsScreen
                ImageDetailsScreen.name -> ImageDetailsScreen

                // if it is empty we return home screen
                null -> HomeScreen

                // anything else we throw an exception
                else -> throw IllegalArgumentException("route $route is not recognized")
            }

    }

}