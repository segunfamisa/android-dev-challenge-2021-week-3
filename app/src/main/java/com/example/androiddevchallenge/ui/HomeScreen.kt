package com.example.androiddevchallenge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.home.*
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

@Composable
fun HomeScreen() {
    var searchText by remember { mutableStateOf("") }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "")
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        bottomBar = {
            BottomNav()
        }
    ) {
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
                                text = stringResource(R.string.search)
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
                                contentDescription = stringResource(R.string.search_cont_desc),
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    )

                    FavoriteCollections(favorites = favorites)
                    Spacer(modifier = Modifier.size(32.dp))
                    AlignRow(
                        text = stringResource(id = R.string.header_align_body),
                        items = alignYourBodyItems,
                        onItemClick = { }
                    )
                    Spacer(modifier = Modifier.size(32.dp))
                    AlignRow(
                        text = stringResource(id = R.string.header_align_mind),
                        items = alignYourMindItems,
                        onItemClick = { }
                    )
                }
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
