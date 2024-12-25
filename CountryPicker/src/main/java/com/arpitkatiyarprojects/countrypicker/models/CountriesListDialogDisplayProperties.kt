package com.arpitkatiyarprojects.countrypicker.models

import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

/**
 * A class representing the display properties for the countries list dialog in a country picker component.
 * This includes configuration options for general properties, flag dimensions, and text styles.
 *
 * @param properties Configuration settings for the countries list dialog, represented by [CountriesListDialogProperties].
 *   This parameter controls dialog-specific properties, such as behavior and layout options.
 * @param flagDimensions Specifies the width and height for the country flag icons displayed within the dialog,
 *   represented by [FlagDimensions]. Default dimensions are set to 30.dp width and 20.dp height.
 * @param textStyles Text styling for the dialog, represented by [CountryPickerDialogTextStyles].
 *   This parameter allows customization of font styles and appearance for text elements in the dialog.
 */
data class CountriesListDialogDisplayProperties(
    val properties: CountriesListDialogProperties = CountriesListDialogProperties(),
    val flagDimensions: FlagDimensions = FlagDimensions(width = 30.dp, height = 20.dp),
    val textStyles: CountryPickerDialogTextStyles = CountryPickerDialogTextStyles(),
    val flagShape: Shape = RectangleShape
)