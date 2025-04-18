package com.arpitkatiyarprojects.countrypicker.utils

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.arpitkatiyarprojects.countrypicker.models.CountryPickerColors
import com.arpitkatiyarprojects.countrypicker.utils.FunctionHelper.getDisabledContentColor

object CountryPickerDefault {

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
     * @param selectedCountryDisabledContainerColor Background color for a disabled selected country container, defaults to transparent.
     * @param dropDownDisabledIconColor Color for the dropdown icon when disabled.
     * @return A [CountryPickerColors] object with the specified colors.
     */
    @Composable
    fun colors(
        dropDownIconColor: Color = LocalContentColor.current,
        backIconColor: Color = LocalContentColor.current,
        searchIconColor: Color = LocalContentColor.current,
        cancelIconColor: Color = LocalContentColor.current,
        searchCursorColor: Color = Color.Unspecified,
        selectedCountryContainerColor: Color = Color.Transparent,
        countriesListContainerColor: Color = MaterialTheme.colorScheme.background,
        selectedCountryDisabledContainerColor: Color = Color.Transparent,
        dropDownDisabledIconColor: Color = getDisabledContentColor()
    ): CountryPickerColors {
        return CountryPickerColors(
            dropDownIconColor = dropDownIconColor,
            backIconColor = backIconColor,
            searchIconColor = searchIconColor,
            cancelIconColor = cancelIconColor,
            searchCursorColor = searchCursorColor,
            selectedCountryContainerColor = selectedCountryContainerColor,
            countriesListContainerColor = countriesListContainerColor,
            selectedCountryDisabledContainerColor = selectedCountryDisabledContainerColor,
            dropDownDisabledIconColor = dropDownDisabledIconColor
        )
    }
}