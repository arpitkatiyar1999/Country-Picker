package com.arpitkatiyarprojects.countrypicker.models

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Configuration class for country picker
 * @param showCountryFlag Specifies whether to display the country flag within the picker.
 * @param showCountryPhoneCode Specifies whether to display the country phone code within the picker.
 * @param showCountryName Specifies whether to display the country name within the picker.
 * @param showCountryCode Specifies whether to display the country code within the picker.
 * @param spaceAfterCountryFlag Defines the spacing after the country flag, if showCountryFlag = true
 * @param spaceAfterCountryPhoneCode Defines the spacing after the country phone code, if showCountryPhoneCode = true.
 * @param spaceAfterCountryName Defines the spacing after the country name, if showCountryName = true.
 * @param spaceAfterCountryCode Defines the spacing after the country code, if showCountryCode = true.
 */
data class CountryPickerProperties(
    val showCountryFlag: Boolean = true,
    val showCountryPhoneCode: Boolean = true,
    val showCountryName: Boolean = false,
    val showCountryCode: Boolean = false,
    val spaceAfterCountryFlag: Dp = 8.dp,
    val spaceAfterCountryPhoneCode: Dp = 6.dp,
    val spaceAfterCountryName: Dp = 6.dp,
    val spaceAfterCountryCode: Dp = 6.dp,
)
