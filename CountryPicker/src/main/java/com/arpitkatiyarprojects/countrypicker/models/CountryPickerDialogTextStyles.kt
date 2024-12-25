package com.arpitkatiyarprojects.countrypicker.models

import androidx.compose.ui.text.TextStyle

/**
 * Defines the text styles for the country picker dialog.
 * @param countryPhoneCodeTextStyle Specifies the [TextStyle] for the country phone code.
 * @param countryNameTextStyle Specifies the [TextStyle] for the country name.
 * @param countryCodeTextStyle Specifies the [TextStyle] for the country code.
 */
data class CountryPickerDialogTextStyles(
    val countryPhoneCodeTextStyle: TextStyle? = null,
    val countryNameTextStyle: TextStyle? = null,
    val countryCodeTextStyle: TextStyle? = null,
    val searchBarHintTextStyle: TextStyle? = null,
    val titleTextStyle: TextStyle? = null
)