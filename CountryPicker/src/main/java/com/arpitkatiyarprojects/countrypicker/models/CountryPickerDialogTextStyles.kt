package com.arpitkatiyarprojects.countrypicker.models

import androidx.compose.ui.text.TextStyle

/**
 * Defines the text styles for the country picker dialog.
 * @param countryPhoneCodeTextStyle Specifies the [TextStyle] for the country phone code.
 * @param countryNameTextStyle Specifies the [TextStyle] for the country name.
 * @param countryCodeTextStyle Specifies the [TextStyle] for the country code.
 * @param searchBarHintTextStyle Text style for the placeholder/hint text in the search bar.
 * @param titleTextStyle Text style for the dialog title (e.g., "Select a Country").
 * @param noSearchedCountryAvailableTextStyle Text style for the message displayed when no countries match the search.
 */
data class CountryPickerDialogTextStyles(
    val countryPhoneCodeTextStyle: TextStyle? = null,
    val countryNameTextStyle: TextStyle? = null,
    val countryCodeTextStyle: TextStyle? = null,
    val searchBarHintTextStyle: TextStyle? = null,
    val titleTextStyle: TextStyle? = null,
    val noSearchedCountryAvailableTextStyle: TextStyle? = null
)