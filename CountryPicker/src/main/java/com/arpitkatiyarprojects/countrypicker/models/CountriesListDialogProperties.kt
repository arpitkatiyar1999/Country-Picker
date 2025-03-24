package com.arpitkatiyarprojects.countrypicker.models

import androidx.compose.runtime.Immutable


/**
 * Configuration class for country list dialog.
 * @param showCountryCode Specifies whether to display the country code for each country.
 */
@Immutable
data class CountriesListDialogProperties(val showCountryCode: Boolean = false)