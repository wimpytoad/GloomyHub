package com.gloomyhub.ui.components

import androidx.compose.foundation.Image
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
import coil.compose.rememberImagePainter
import com.gloomyhub.R
import com.gloomyhub.domain.movie_feed.model.MovieItem
import com.gloomyhub.ui.theme.BrownLight
import com.gloomyhub.ui.theme.TextDark

@Composable
fun MovieListItem(movieItem: MovieItem, onClick: (item: MovieItem) -> Unit) {
    val sidePadding = dimensionResource(id = R.dimen.padding_16)
    val containerPadding = dimensionResource(id = R.dimen.padding_8)

    Box(modifier = Modifier
        .padding(
            top = containerPadding,
            bottom = containerPadding,
            start = sidePadding,
            end = sidePadding
        )
        .background(BrownLight)
        .clickable {
            onClick(movieItem)
        }) {

        Row() {
            Image(
                painter = rememberImagePainter(movieItem.posterUrl),
                contentDescription = null,
                Modifier.weight(1.0f),
                contentScale = ContentScale.Fit
            )

            Column(
                modifier = Modifier
                    .weight(2.0f)
                    .padding(sidePadding)
            ) {

                Text(
                    text = movieItem.title,
                    textAlign = TextAlign.Start,
                    color = TextDark,
                    style = MaterialTheme.typography.body1
                )

                Spacer(modifier = Modifier.size(sidePadding))

                Text(
                    text = movieItem.description,
                    textAlign = TextAlign.Start,
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}