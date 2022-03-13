package com.gloomyhub.ui.navigation

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.*
import com.google.accompanist.navigation.animation.composable

const val transitionDuration = 400
const val slideTransitionDelay = 200


@ExperimentalAnimationApi
fun NavGraphBuilder.verticalSlide(
    route: String,
    arguments: List<NamedNavArgument> = listOf(),
    content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
) {
    composable(route,
        arguments = arguments,
        enterTransition = { ->
            slideInVertically(initialOffsetY = { it }, animationSpec = tween(transitionDuration))
        }, popExitTransition = { ->
            slideOutVertically(targetOffsetY = { it }, animationSpec = tween(transitionDuration))
        }, popEnterTransition = { ->
            fadeIn(initialAlpha = 0.5f, animationSpec = tween(transitionDuration))
        }, content = content)
}

@ExperimentalAnimationApi
fun NavGraphBuilder.horizontalSlide(
    route: String,
    arguments: List<NamedNavArgument> = listOf(),
    content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit) {
    composable(route, arguments = arguments, enterTransition = { ->
        slideInHorizontally(initialOffsetX = { it },
            animationSpec = tween(transitionDuration, slideTransitionDelay))
    }, exitTransition = { ->
        fadeOut(targetAlpha = 0.5f, animationSpec = tween(transitionDuration))
    }, popExitTransition = { ->
        slideOutHorizontally(targetOffsetX = { it }, animationSpec = tween(transitionDuration))
    }, popEnterTransition = { ->
        fadeIn(initialAlpha = 0.5f, animationSpec = tween(transitionDuration, slideTransitionDelay))
    }, content = content)
}

/**
 * allows popping up to destination while clearing all backstack entries
 */
fun NavOptionsBuilder.popUpToTop(navController: NavController) {
    popUpTo(navController.currentBackStackEntry?.destination?.route ?: return) {
        inclusive =  true
    }
}