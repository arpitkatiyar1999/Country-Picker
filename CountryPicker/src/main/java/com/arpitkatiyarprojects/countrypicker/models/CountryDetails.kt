package com.arpitkatiyarprojects.countrypicker.models

import androidx.annotation.DrawableRes

data class CountryDetails(
    var countryCode: String,
    val countryPhoneNumberCode: String,
    val countryName: String,
    @DrawableRes val countryFlag: Int
)