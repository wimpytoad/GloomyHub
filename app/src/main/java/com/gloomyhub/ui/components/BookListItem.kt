package com.gloomyhub.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import com.gloomyhub.R
import com.gloomyhub.domain.horror_search.model.BookItem
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun BookListItem(bookItem: BookItem, onClick: (item: BookItem) -> Unit) {
    val sidePadding = dimensionResource(id = R.dimen.padding_16)
    val containerPadding = dimensionResource(id = R.dimen.padding_8)

    Column(modifier = Modifier
        .padding(top = containerPadding,
            bottom = containerPadding,
            start = sidePadding,
            end = sidePadding)
        .background(MaterialTheme.colors.secondary)
        .clickable {
            onClick(bookItem)
        }) {
        Row(modifier = Modifier
            .padding(sidePadding)
            .fillMaxWidth()) {
            GlideImage(imageModel = bookItem.cover.smallThumbnail,
                contentScale = ContentScale.Inside)

            Column() {
                Text(
                    text = bookItem.authors[0], textAlign = TextAlign.Start,
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.body1
                )
                Spacer(modifier = Modifier.size(sidePadding))

                Text(
                    text = bookItem.description, textAlign = TextAlign.Start,
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }

}