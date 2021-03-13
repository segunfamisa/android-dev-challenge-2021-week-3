package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun WelcomeScreen(
    onSignUpClick: () -> Unit,
    onLogInClick: () -> Unit
) {
    val (welcomeBg, logo) = if (MaterialTheme.colors.isLight) {
        Pair(
            painterResource(id = R.drawable.light_welcome_bg),
            painterResource(id = R.drawable.ic_light_logo)
        )
    } else {
        Pair(
            painterResource(id = R.drawable.dark_welcome_bg),
            painterResource(id = R.drawable.ic_dark_logo)
        )
    }
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        Image(
            painter = welcomeBg,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize(),
            contentDescription = ""
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .wrapContentHeight(align = Alignment.CenterVertically)
                .wrapContentWidth(align = Alignment.CenterHorizontally)
        ) {
            Image(
                painter = logo,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(),
                contentDescription = stringResource(id = R.string.logo_cont_desc)
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                modifier = Modifier
                    .height(72.dp)
                    .fillMaxWidth(),
                shape = MaterialTheme.shapes.medium,
                onClick = onSignUpClick,
            ) {
                Text(
                    text = stringResource(id = R.string.sign_up),
                    style = MaterialTheme.typography.button
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                modifier = Modifier
                    .height(72.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary
                ),
                shape = MaterialTheme.shapes.medium,
                onClick = onLogInClick
            ) {
                Text(
                    text = stringResource(id = R.string.log_in),
                    style = MaterialTheme.typography.button,
                )
            }
        }
    }
}

@Composable
@Preview
fun WelcomeScreenPreview() {
    MyTheme {
        WelcomeScreen(onSignUpClick = { }, onLogInClick = {})
    }
}
