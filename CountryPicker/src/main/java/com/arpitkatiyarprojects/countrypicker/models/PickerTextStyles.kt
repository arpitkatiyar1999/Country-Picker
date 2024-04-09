package com.arpitkatiyarprojects.countrypicker.models

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

/**
 * Defines the text styles for the picker items
 * @param countryPhoneCodeTextStyle Specifies the text style for the country phone code
 * @param countryNameTextStyle Specifies the text style for the country name.
 * @param countryCodeTextStyle Specifies the text style for the country code.
 */
data class PickerTextStyles(
    val countryPhoneCodeTextStyle: TextStyle = TextStyle(fontWeight = FontWeight.Bold),
    val countryNameTextStyle: TextStyle = TextStyle(),
    val countryCodeTextStyle: TextStyle = TextStyle()
)