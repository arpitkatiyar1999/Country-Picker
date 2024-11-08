package com.arpitkatiyarprojects.countrypickerproject.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun SelectedCountrySettings(
    selectedCountryFlagWidthState: MutableState<Dp>,
    selectedCountryFlagHeightState: MutableState<Dp>,
    showSelectedCountryFlagState: MutableState<Boolean>,
    showSelectedCountryPhoneCodeState: MutableState<Boolean>,
    showSelectedCountryNameState: MutableState<Boolean>,
    showSelectedCountryCodeState: MutableState<Boolean>,
    spaceAfterSelectedCountryFlagMutableState: MutableState<Dp>,
    spaceAfterSelectedCountryPhoneCode: MutableState<Dp>,
    spaceAfterSelectedCountryName: MutableState<Dp>,
    spaceAfterSelectedCountryCode: MutableState<Dp>,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        TextWidthHeightRow(selectedCountryFlagWidthState, selectedCountryFlagHeightState)
        SpacerHeight4()
        TextSwitchRow(text = "Show Country Flag", showSelectedCountryFlagState)
        SpacerHeight4()
        TextSwitchRow(text = "Show Country Phone Code", showSelectedCountryPhoneCodeState)
        SpacerHeight4()
        TextSwitchRow(text = "Show Country Name", showSelectedCountryNameState)
        SpacerHeight4()
        TextSwitchRow(text = "Show Country Code", showSelectedCountryCodeState)
        SpacerHeight4()
        TextProgressRow(
            text = "Space After Country Flag",
            valueChangeMutableState = spaceAfterSelectedCountryFlagMutableState
        )
        SpacerHeight4()
        TextProgressRow(
            text = "Space After Country Phone Code",
            valueChangeMutableState = spaceAfterSelectedCountryPhoneCode
        )
        SpacerHeight4()
        TextProgressRow(
            text = "Space After Country Name",
            valueChangeMutableState = spaceAfterSelectedCountryName
        )
        SpacerHeight4()
        TextProgressRow(
            text = "Space After Country Code",
            valueChangeMutableState = spaceAfterSelectedCountryCode
        )
    }
}