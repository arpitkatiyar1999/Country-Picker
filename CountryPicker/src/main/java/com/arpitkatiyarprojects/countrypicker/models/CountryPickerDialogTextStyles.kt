package com.arpitkatiyarprojects.countrypicker.models

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

/**
 * Defines the text styles for the country picker dialog.
 * @param countryPhoneCodeTextStyle Specifies the [TextStyle] for the country phone code.
 * @param countryNameTextStyle Specifies the [TextStyle] for the country name.
 * @param countryCodeTextStyle Specifies the [TextStyle] for the country code.
 */
data class CountryPickerDialogTextStyles(
    val countryPhoneCodeTextStyle: TextStyle,
    val countryNameTextStyle: TextStyle,
    val countryCodeTextStyle: TextStyle
) {
    companion object {
        /**
         * Provides default text styles for displaying country information in a dialog.
         * @return A `CountryPickerDialogTextStyles` instance with predefined text styles
         *         for country phone code, name, and code.
         */
        @Composable
        internal fun defaultTextStyles(): CountryPickerDialogTextStyles {
            return CountryPickerDialogTextStyles(
                countryPhoneCodeTextStyle = MaterialTheme.typography.bodyMedium,
                countryNameTextStyle = MaterialTheme.typography.bodyMedium,
                countryCodeTextStyle = MaterialTheme.typography.bodyMedium
            )
        }
    }
}