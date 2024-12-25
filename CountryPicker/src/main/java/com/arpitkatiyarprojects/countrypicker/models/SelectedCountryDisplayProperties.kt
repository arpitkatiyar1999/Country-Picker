package com.arpitkatiyarprojects.countrypicker.models

import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp


/**
 * A  class representing the properties for displaying a selected country.
 *
 * @param properties A set of properties to customize the visibility and spacing of country display elements,
 *   represented by [SelectedCountryProperties]. These properties control the visibility of
 *   flags, country codes, and spacing between elements.
 * @param flagDimensions Specifies the dimensions of the country flag, represented by [FlagDimensions].
 *    It defines the width and height of the flag for the selected country.
 * @param textStyles Defines the styles for text elements associated with the selected country,
 *   represented by [SelectedCountryTextStyles]. This includes the text styles for
 *   country code, country name, and phone code.
 * @param flagShape Shape of the country flag (e.g., rectangle , rounded etc).
 */
data class SelectedCountryDisplayProperties(
    val properties: SelectedCountryProperties = SelectedCountryProperties(),
    val flagDimensions: FlagDimensions = FlagDimensions(width = 28.dp, height = 18.dp),
    val textStyles: SelectedCountryTextStyles = SelectedCountryTextStyles(),
    val flagShape: Shape = RectangleShape
)