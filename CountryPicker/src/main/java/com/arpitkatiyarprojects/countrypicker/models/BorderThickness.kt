package com.arpitkatiyarprojects.countrypicker.models

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * class representing the border thickness for focused and unfocused states.
 * @property focusedBorderThickness The thickness of the border when focused.
 * @property unfocusedBorderThickness The thickness of the border when unfocused.
 */
data class BorderThickness(
    val focusedBorderThickness: Dp = 2.dp,
    val unfocusedBorderThickness: Dp = 1.dp
)