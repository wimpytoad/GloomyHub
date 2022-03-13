package com.gloomyhub.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.gloomyhub.R
import com.gloomyhub.domain.horror_search.model.BookItem
import com.gloomyhub.domain.horror_search.model.Cover

@Composable
fun BookListItem(bookItem: BookItem, onClick: (item: BookItem) -> Unit) {
    val sidePadding = dimensionResource(id = R.dimen.padding_16)
    val containerPadding = dimensionResource(id = R.dimen.padding_8)

    Box(modifier = Modifier
        .padding(top = containerPadding,
            bottom = containerPadding,
            start = sidePadding,
            end = sidePadding)
        .background(MaterialTheme.colors.error)
        .clickable {
            onClick(bookItem)
        }) {

        Row() {
            Image(painter = rememberImagePainter("https://static.wixstatic.com/media/e9e4bf_ef1d9e5523854628bb8d0ee9a239ae73~mv2.jpg/v1/fit/w_603%2Ch_939%2Cal_c%2Cq_80/file.jpg"),
                contentDescription = null,
                Modifier.weight(1.0f).size (128.dp),
                contentScale = ContentScale.Fit)

            Column(modifier = Modifier.weight(2.0f).padding(sidePadding)) {

                Text(text = bookItem.authors[0],
                    textAlign = TextAlign.Start,
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.body1)

                Spacer(modifier = Modifier.size(sidePadding))

                Text(text = bookItem.description,
                    textAlign = TextAlign.Start,
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.body1)
            }
        }
    }
}

@Preview
@Composable
fun cardPreview() {
    BookListItem(bookItem = BookItem("0",
        listOf("Lovecraft Edward"),
        "The Fisherman",
        0,
        emptyList(),
        "A weird tale about most weird things to ever exist. A weird tale about most weird things to ever exist. A weird tale about most weird things to ever exist.",
        Cover("https://i0.wp.com/www.castaliahouse.com/wp-content/uploads/2017/03/callofcthulhu.jpg?w=500",
            "")), onClick = {})
}