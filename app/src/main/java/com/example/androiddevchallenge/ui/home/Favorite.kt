package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import dev.chrisbanes.accompanist.coil.CoilImage


private const val columnHeight = 2

data class Favorite(val name: String, val url: String)

@Composable
fun FavoriteCollections(
    favorites: List<Favorite> = emptyList()
) {
    SectionHeader(
        text = stringResource(R.string.favorite_header),
        modifier = Modifier.paddingFromBaseline(top = 40.dp)
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(state = rememberScrollState(), enabled = true)
    ) {
        favorites.windowed(columnHeight, columnHeight)
            .forEach {
                FavoritesColumn(height = columnHeight, columnItems = it, onFavoriteClick = {})
                Spacer(modifier = Modifier.size(8.dp))
            }
    }
}

@Composable
fun FavoritesColumn(
    height: Int,
    columnItems: List<Favorite>,
    onFavoriteClick: (Favorite) -> Unit
) {
    val items = columnItems.take(height)
    Column(modifier = Modifier.wrapContentSize()) {
        items.spacedForEach(
            spacer = {
                Spacer(modifier = Modifier.size(8.dp))
            }) { favorite ->
            FavoriteCell(favorite = favorite, onFavoriteClick = onFavoriteClick)
        }
    }
}

@Composable
fun FavoriteCell(
    favorite: Favorite,
    onFavoriteClick: (Favorite) -> Unit
) {
    Surface(
        color = MaterialTheme.colors.surface,
        modifier = Modifier
            .clickable(enabled = true, onClick = { onFavoriteClick(favorite) })
            .clip(shape = MaterialTheme.shapes.small)
    ) {
        Row(
            modifier = Modifier
                .requiredWidth(192.dp)
                .requiredHeight(56.dp)
        ) {
            CoilImage(
                data = favorite.url,
                contentDescription = "${favorite.name} icon",
                fadeIn = true,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .requiredHeight(56.dp)
                    .requiredWidth(56.dp)
            )
            Text(
                text = favorite.name,
                style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .wrapContentSize(align = Alignment.Center)
            )
        }
    }
    Spacer(modifier = Modifier.size(8.dp))
}
