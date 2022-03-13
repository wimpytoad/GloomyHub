package com.gloomyhub.ui.navigation

import android.widget.TextView
import androidx.annotation.StringRes
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.gloomyhub.R
import com.gloomyhub.ui.screens.curatedBooksRoute
import com.gloomyhub.ui.screens.curatedMoviesRoute

@Composable
fun BottomNavBar(
    navController: NavController,
    navigationItems: List<NavigationItem> = listOf(
        NavigationItem.BookSelectionScreen,
        NavigationItem.MovieSelectionScreen)) {

   BottomNavigation(backgroundColor = Color.DarkGray) {
       val navBackStackEntry = navController.currentBackStackEntryAsState()
       val currentRoute = navBackStackEntry.value?.destination?.route

       navigationItems.forEach { item ->
           val isSelected = currentRoute == item.route

           BottomNavigationItem(selected = isSelected,  onClick = {
               navController.navigate(item.route) {
                   // Pop up to the start destination of the graph to
                   // avoid building up a large stack of destinations
                   // on the back stack as users select items
                   navController.graph.startDestinationRoute?.let { route ->
                       popUpTo(route) {
                           saveState = true
                       }
                   }
                   // Avoid multiple copies of the same destination when
                   // reselecting the same item
                   launchSingleTop = true
                   // Restore state when reselecting a previously selected item
                   restoreState = true
               }
           }, label = {
               Text(text = stringResource(id = item.title))
           }, icon = {

           })

       }
   }

}

sealed class NavigationItem(val route: String, @StringRes val title: Int) {
    object BookSelectionScreen : NavigationItem(curatedBooksRoute, R.string.book_screen_title)
    object MovieSelectionScreen :
        NavigationItem(curatedMoviesRoute, R.string.movie_screen_title)
}