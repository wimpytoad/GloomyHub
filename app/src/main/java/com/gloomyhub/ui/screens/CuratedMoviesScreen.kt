package com.gloomyhub.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.gloomyhub.ui.components.MovieListItem
import com.gloomyhub.ui.navigation.BottomNavBar
import com.gloomyhub.vms.CuratedMoviesViewModel
import org.koin.androidx.compose.getViewModel

const val curatedMoviesRoute = "curated_movies_route"

@Composable
fun CuratedMoviesScreen(
    viewModel: CuratedMoviesViewModel = getViewModel(),
    navController: NavController
) {

    val movieList = viewModel.suggestionsState.collectAsState()

    Scaffold(bottomBar = {
        BottomNavBar(navController = navController)
    }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            itemsIndexed(movieList.value) { index, item ->
                MovieListItem(movieItem = item, onClick = {})
            }
        }
    }

}