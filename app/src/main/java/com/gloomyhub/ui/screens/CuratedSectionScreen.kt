package com.gloomyhub.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.gloomyhub.ui.components.BookListItem
import com.gloomyhub.vms.CuratedSectionViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun CuratedSectionScreen(viewModel: CuratedSectionViewModel = getViewModel()) {

    val bookList = viewModel.suggestionsState.collectAsState()

    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()) {
            itemsIndexed(bookList.value) {index, item ->
                BookListItem(bookItem = item, onClick =
                {

                })
            }
    }

}