package com.arpitkatiyarprojects.countrypicker.models

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable


/**
 * Class representing country details including country code, phone number code, country name, and country flag.
 * @property countryCode The code of the country.
 * @property countryPhoneNumberCode The phone number code of the country.
 * @property countryName The name of the country.
 * @property countryFlag The drawable resource ID of the country flag.
 */
@Immutable
data class CountryDetails(
    val countryCode: String,
    val countryPhoneNumberCode: String,
    val countryName: String,
    @DrawableRes val countryFlag: Int
)