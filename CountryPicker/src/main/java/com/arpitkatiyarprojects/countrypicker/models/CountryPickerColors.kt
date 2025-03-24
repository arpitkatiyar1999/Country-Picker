package com.arpitkatiyarprojects.countrypicker.models

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color


/**
 * Defines a set of colors for the Country Picker component.
 *
 * @param dropDownIconColor Color for the dropdown icon, defaults to the current content color.
 * @param backIconColor Color for the back icon, defaults to the current content color.
 * @param searchIconColor Color for the search icon, defaults to the current content color.
 * @param cancelIconColor Color for the cancel (clear) icon, defaults to the current content color.
 * @param searchCursorColor Color for the search field cursor, defaults to unspecified.
 * @param selectedCountryContainerColor Background color for the selected country container, defaults to transparent.
 * @param countriesListContainerColor Background color for the countries list container, defaults to MaterialTheme background.
 **/
@Immutable
data class CountryPickerColors(
    val dropDownIconColor: Color,
    val backIconColor: Color,
    val searchIconColor: Color,
    val cancelIconColor: Color,
    val searchCursorColor: Color,
    val selectedCountryContainerColor: Color,
    val countriesListContainerColor: Color
)