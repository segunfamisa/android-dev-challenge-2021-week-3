package com.example.androiddevchallenge.ui.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.example.androiddevchallenge.R

data class NavItem(val icon: ImageVector, val title: String)

@Composable
fun BottomNav() {
    val items = listOf(
        NavItem(Icons.Default.Spa, stringResource(id = R.string.nav_home)),
        NavItem(Icons.Default.AccountCircle, stringResource(id = R.string.nav_profile))
    )
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background
    ) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                selected = index % 2 == 0,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(item.icon, contentDescription = item.title)
                },
                label = {
                    Text(text = item.title, style = MaterialTheme.typography.caption)
                }
            )
        }
    }
}
