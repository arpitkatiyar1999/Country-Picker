package com.arpitkatiyarprojects.countrypicker.models

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

/**
 * Defines the text styles for the selected country.
 * @param countryPhoneCodeTextStyle Specifies the [TextStyle] for the selected country phone code
 * @param countryNameTextStyle Specifies the [TextStyle] for the selected country name.
 * @param countryCodeTextStyle Specifies the [TextStyle] for the selected country code.
 */
data class SelectedCountryTextStyles(
    val countryPhoneCodeTextStyle: TextStyle = TextStyle(fontWeight = FontWeight.Bold),
    val countryNameTextStyle: TextStyle = TextStyle(),
    val countryCodeTextStyle: TextStyle = TextStyle()
)
