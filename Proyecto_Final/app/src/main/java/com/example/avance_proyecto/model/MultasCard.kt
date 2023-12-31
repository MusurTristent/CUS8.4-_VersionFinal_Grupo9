package com.example.avance_proyecto.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class MultasCard(
    @DrawableRes val imageRes: Int,
    val lightColor: Color,
    val mediumColor: Color,
    val darkColor: Color
)
