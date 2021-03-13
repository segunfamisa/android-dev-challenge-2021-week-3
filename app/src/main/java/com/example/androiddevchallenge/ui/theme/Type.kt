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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R

val kulimFamily = FontFamily(
    fonts = listOf(
        Font(
            resId = R.font.kulim_park_light,
            weight = FontWeight.Light,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.kulim_park_regular,
            weight = FontWeight.Normal,
            style = FontStyle.Normal
        )
    )
)
val latoFamily = FontFamily(
    fonts = listOf(
        Font(
            resId = R.font.lato_bold,
            weight = FontWeight.Bold,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.lato_regular,
            weight = FontWeight.Normal,
            style = FontStyle.Normal
        )
    )
)

// Set of Material typography styles to start with
private val defaultTypography = Typography()
val typography = Typography(
    h1 = defaultTypography.h1.copy(
        fontSize = 28.sp,
        letterSpacing = 1.15.sp,
        fontFamily = kulimFamily,
        fontWeight = FontWeight.Light
    ),
    h2 = defaultTypography.h2.copy(
        fontSize = 14.sp,
        letterSpacing = 1.15.sp,
        fontFamily = kulimFamily
    ), // TODO specify caps
    h3 = defaultTypography.h3.copy(
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        fontFamily = latoFamily,
        fontWeight = FontWeight.Bold
    ),
    body1 = defaultTypography.body1.copy(fontSize = 14.sp, fontFamily = latoFamily),
    button = defaultTypography.button.copy(
        fontSize = 14.sp,
        fontFamily = latoFamily,
        fontWeight = FontWeight.Bold
    ),
    caption = defaultTypography.caption.copy(
        fontSize = 12.sp,
        letterSpacing = 1.15.sp,
        fontWeight = FontWeight.Normal
    ) // TODO specify caps
)
