/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.home.AlignRow
import com.example.androiddevchallenge.ui.home.BottomNav
import com.example.androiddevchallenge.ui.home.Favorite
import com.example.androiddevchallenge.ui.home.FavoriteCollections
import com.example.androiddevchallenge.ui.home.alignYourBodyItems
import com.example.androiddevchallenge.ui.home.alignYourMindItems
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

@Composable
fun HomeScreen() {
    val focusManager = LocalFocusManager.current
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
                        .verticalScroll(state = rememberScrollState(), enabled = true)
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
                        singleLine = true,
                        keyboardActions = KeyboardActions(
                            onDone = {
                                focusManager.clearFocus()
                            }
                        ),
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
