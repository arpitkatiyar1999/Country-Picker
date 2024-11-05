package com.arpitkatiyarprojects.countrypicker.models

import androidx.compose.ui.text.TextStyle

/**
 * Defines the text styles for the picker items
 * @param countryPhoneCodeTextStyle Specifies the text style for the country phone code
 * @param countryNameTextStyle Specifies the text style for the country name.
 * @param countryCodeTextStyle Specifies the text style for the country code.
 */
data class CountryPickerTextStyles(
    val countryPhoneCodeTextStyle: TextStyle,
    val countryNameTextStyle: TextStyle,
    val countryCodeTextStyle: TextStyle
)