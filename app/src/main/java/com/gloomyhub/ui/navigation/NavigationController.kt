package com.gloomyhub.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gloomyhub.ui.screens.CuratedMoviesScreen
import com.gloomyhub.ui.screens.CuratedSectionScreen
import com.gloomyhub.ui.screens.curatedBooksRoute
import com.gloomyhub.ui.screens.curatedMoviesRoute
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavigationController() {
    val navController = rememberAnimatedNavController()
    
    NavHost(navController = navController, startDestination = curatedBooksRoute) {
        composable(curatedBooksRoute) {
            CuratedSectionScreen(navController = navController)
        }
        
        composable(curatedMoviesRoute) {
            CuratedMoviesScreen(navController = navController)
        }
    }

}