package com.arpitkatiyarprojects.countrypickerproject.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun CountriesListDialogSettings(
    countryListFlagWidthState: MutableState<Dp>,
    countryListFlagHeightState: MutableState<Dp>,
    countryListShowCountryCode: MutableState<Boolean>
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        TextWidthHeightRow(countryListFlagWidthState, countryListFlagHeightState)
        SpacerHeight4()
        TextSwitchRow(text = "Show Country Code", countryListShowCountryCode)
    }
}