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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.HomeScreen
import com.example.androiddevchallenge.ui.LoginScreen
import com.example.androiddevchallenge.ui.Routes
import com.example.androiddevchallenge.ui.WelcomeScreen
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        ViewCompat.setOnApplyWindowInsetsListener(window.decorView.rootView) { _, insets ->
            insets
        }
        setContent {
            MyTheme {
                ProvideWindowInsets {
                    MyApp()
                }
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Welcome) {
        composable(Routes.Welcome) {
            WelcomeScreen(onSignUpClick = {
                navController.navigate(Routes.SignUp)
            }, onLogInClick = {
                navController.navigate(Routes.LogIn)
            })
        }

        composable(Routes.SignUp) {
            Text("Sign up screen")
        }

        composable(Routes.LogIn) {
            LoginScreen(
                onLogInClick = { _, _ -> },
                onLogInSuccessful = {},
                onSignUpClick = {
                    navController.navigate(Routes.SignUp)
                }
            )
        }
    }
}
