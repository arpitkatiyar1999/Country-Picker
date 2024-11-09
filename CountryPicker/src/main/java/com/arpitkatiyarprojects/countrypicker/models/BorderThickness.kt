package com.arpitkatiyarprojects.countrypicker.models

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * class representing the border thickness for focused and unfocused states.
 * @property focusedBorderThickness The thickness of the border when focused, represented as a [Dp].
 * @property unfocusedBorderThickness The thickness of the border when unfocused, represented as a [Dp].
 */
data class BorderThickness(
    val focusedBorderThickness: Dp = 2.dp,
    val unfocusedBorderThickness: Dp = 1.dp
)