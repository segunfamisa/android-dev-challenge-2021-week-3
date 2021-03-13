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
package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.coil.CoilImage

val alignYourBodyItems = listOf(
    AlignItem(
        "Inversions",
        "https://images.pexels.com/photos/317157/pexels-photo-317157.jpeg?cs=srgb&dl=pexels-chevanon-photography-317157.jpg&fm=jpg"
    ),
    AlignItem(
        "Quick yoga",
        "https://images.pexels.com/photos/1812964/pexels-photo-1812964.jpeg?cs=srgb&dl=pexels-agung-pandit-wiguna-1812964.jpg&fm=jpg"
    ),
    AlignItem(
        "Stretching",
        "https://images.pexels.com/photos/4056723/pexels-photo-4056723.jpeg?cs=srgb&dl=pexels-cliff-booth-4056723.jpg&fm=jpg"
    ),
    AlignItem(
        "Tabata",
        "https://images.pexels.com/photos/4662438/pexels-photo-4662438.jpeg?cs=srgb&dl=pexels-elly-fairytale-4662438.jpg&fm=jpg"
    ),
    AlignItem(
        "HIIT",
        "https://images.pexels.com/photos/999309/pexels-photo-999309.jpeg?cs=srgb&dl=pexels-the-lazy-artist-gallery-999309.jpg&fm=jpg"
    ),
    AlignItem(
        "Pre-natal yoga",
        "https://images.pexels.com/photos/396133/pexels-photo-396133.jpeg?cs=srgb&dl=pexels-freestocksorg-396133.jpg&fm=jpg"
    )
)

val alignYourMindItems = listOf(
    AlignItem(
        "Meditate",
        "https://images.pexels.com/photos/3822622/pexels-photo-3822622.jpeg?cs=srgb&dl=pexels-elly-fairytale-3822622.jpg&fm=jpg"
    ),
    AlignItem(
        "With kids",
        "https://images.pexels.com/photos/3094230/pexels-photo-3094230.jpeg?cs=srgb&dl=pexels-valeria-ushakova-3094230.jpg&fm=jpg"
    ),
    AlignItem(
        "Aromatherapy",
        "https://images.pexels.com/photos/4498318/pexels-photo-4498318.jpeg?cs=srgb&dl=pexels-karolina-grabowska-4498318.jpg&fm=jpg"
    ),
    AlignItem(
        "On the go",
        "https://images.pexels.com/photos/1241348/pexels-photo-1241348.jpeg?cs=srgb&dl=pexels-suraphat-nueaon-1241348.jpg&fm=jpg"
    ),
    AlignItem(
        "With pets",
        "https://images.pexels.com/photos/4056535/pexels-photo-4056535.jpeg?cs=srgb&dl=pexels-cottonbro-4056535.jpg&fm=jpg"
    ),
    AlignItem(
        "High stress",
        "https://images.pexels.com/photos/897817/pexels-photo-897817.jpeg?cs=srgb&dl=pexels-nathan-cowley-897817.jpg&fm=jpg"
    ),
)

data class AlignItem(val name: String, val image: String)

@Composable
fun AlignRow(
    text: String,
    items: List<AlignItem> = listOf(),
    onItemClick: (AlignItem) -> Unit
) {
    SectionHeader(text = text)
    Spacer(modifier = Modifier.size(8.dp))
    ItemsRow(items = items, onItemClick)
}

@Composable
private fun ItemsRow(
    items: List<AlignItem> = listOf(),
    onAlignItemClick: (AlignItem) -> Unit
) {
    Row(
        modifier = Modifier.horizontalScroll(state = rememberScrollState())
    ) {
        items.forEachIndexed { index, alignItem ->
            AlignElement(alignItem) { onAlignItemClick(alignItem) }
            if (index != items.size - 1) {
                Spacer(modifier = Modifier.size(8.dp))
            }
        }
    }
}

@Composable
private fun AlignElement(
    item: AlignItem,
    onAlignItemClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .wrapContentSize(align = Alignment.Center)
            .clickable(enabled = true, onClick = onAlignItemClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CoilImage(
            data = item.image,
            contentDescription = "${item.name} image",
            contentScale = ContentScale.Crop,
            fadeIn = true,
            modifier = Modifier
                .requiredSize(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = item.name,
            style = MaterialTheme.typography.h3,
            modifier = Modifier.paddingFromBaseline(top = 24.dp)
        )
    }
}
