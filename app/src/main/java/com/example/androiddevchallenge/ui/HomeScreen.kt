package com.example.androiddevchallenge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.home.Favorite
import com.example.androiddevchallenge.ui.home.FavoriteCollections
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

@Composable
fun HomeScreen() {
    var searchText by remember { mutableStateOf("") }
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        ProvideWindowInsets {
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, top = 56.dp, end = 16.dp)
                    .fillMaxSize()
            ) {
                TextField(
                    value = searchText,
                    label = {
                        Text(
                            text = stringResource(R.string.search),
                            style = MaterialTheme.typography.body1,
                            color = contentColorFor(backgroundColor = MaterialTheme.colors.surface)
                        )
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.surface
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically),
                    textStyle = MaterialTheme.typography.body1,
                    onValueChange = { searchText = it },
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Search,
                            contentDescription = stringResource(R.string.search_cont_desc)
                        )
                    }
                )

                FavoriteCollections(favorites = favorites)
            }
        }
    }
}

private val favorites = listOf(
    Favorite(
        "Short matras",
        "https://images.pexels.com/photos/4515858/pexels-photo-4515858.jpeg?cs=srgb&dl=pexels-jacob-kelvinj-4515858.jpg&fm=jpg"
    ),
    Favorite(
        "Nature meditations",
        "https://images.pexels.com/photos/3571551/pexels-photo-3571551.jpeg?cs=srgb&dl=pexels-nothing-ahead-3571551.jpg&fm=jpg"
    ),
    Favorite(
        "Stress & anxiety",
        "https://images.pexels.com/photos/1557238/pexels-photo-1557238.jpeg?cs=srgb&dl=pexels-jim-1557238.jpg&fm=jpg"
    ),
    Favorite(
        "Self-massage",
        "https://images.pexels.com/photos/924824/pexels-photo-924824.jpeg?cs=srgb&dl=pexels-jakub-novacek-924824.jpg&fm=jpg"
    )
)
