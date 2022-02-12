package com.gloomyhub.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gloomyhub.domain.horror_search.model.BookItem
import com.gloomyhub.ui.components.BookListItem

@Composable
fun CuratedSectionScreen(books: List<BookItem>, ) {

    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()) {
        itemsIndexed(items = books) { index, item ->
            BookListItem(bookItem = item, onClick = {

            })
        }
    }
}