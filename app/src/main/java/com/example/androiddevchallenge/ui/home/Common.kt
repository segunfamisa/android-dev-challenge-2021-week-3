package com.example.androiddevchallenge.ui.home

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun <T> List<T>.spacedForEach(spacer: @Composable () -> Unit, action: @Composable (T) -> Unit) {
    this.forEachIndexed { index, item ->
        if (index != size - 1) {
            spacer()
        }
        action(item)
    }
}

@Composable
fun SectionHeader(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.h2,
        modifier = modifier
    )
}
