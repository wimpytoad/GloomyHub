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
import com.gloomyhub.ui.components.BookListItem
import com.gloomyhub.ui.navigation.BottomNavBar
import com.gloomyhub.vms.CuratedBooksViewModel
import org.koin.androidx.compose.getViewModel

const val curatedBooksRoute = "curated_books_route"

@Composable
fun CuratedSectionScreen(
    viewModel: CuratedBooksViewModel = getViewModel(),
    navController: NavController) {

    val bookList = viewModel.suggestionsState.collectAsState()

    Scaffold(bottomBar = {
        BottomNavBar(navController = navController)
    }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()) {
            itemsIndexed(bookList.value) { index, item ->
                BookListItem(bookItem = item, onClick = {

                })
            }
        }
    }
}
