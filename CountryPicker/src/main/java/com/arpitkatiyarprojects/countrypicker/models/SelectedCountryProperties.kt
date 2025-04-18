package com.arpitkatiyarprojects.countrypicker.models

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Configuration class for selected country.
 * @param showCountryFlag Specifies whether to display the country flag for selected country.
 * @param showCountryPhoneCode Specifies whether to display the country phone code for selected country.
 * @param showCountryName Specifies whether to display the country name for selected country.
 * @param showCountryCode Specifies whether to display the country code for selected country.
 * @param spaceAfterCountryFlag Defines the spacing after the country flag, iff showCountryFlag = true , represented as [Dp].
 * @param spaceAfterCountryPhoneCode Defines the spacing after the country phone code, iff showCountryPhoneCode = true , represented as [Dp].
 * @param spaceAfterCountryName Defines the spacing after the country name, iff showCountryName = true , represented as [Dp].
 * @param spaceAfterCountryCode Defines the spacing after the country code, iff showCountryCode = true , represented as [Dp].
 * @param showDropDownIcon If true, shows the dropdown icon next to the selected country.
 */
@Immutable
data class SelectedCountryProperties(
    val showCountryFlag: Boolean = true,
    val showCountryPhoneCode: Boolean = true,
    val showCountryName: Boolean = false,
    val showCountryCode: Boolean = false,
    val spaceAfterCountryFlag: Dp = 8.dp,
    val spaceAfterCountryPhoneCode: Dp = 6.dp,
    val spaceAfterCountryName: Dp = 6.dp,
    val spaceAfterCountryCode: Dp = 6.dp,
    val showDropDownIcon: Boolean = true
)
