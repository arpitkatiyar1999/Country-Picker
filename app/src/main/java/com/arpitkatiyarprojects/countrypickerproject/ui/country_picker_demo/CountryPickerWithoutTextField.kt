package com.arpitkatiyarprojects.countrypickerproject.ui.country_picker_demo

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.arpitkatiyarprojects.countrypicker.CountryPicker
import com.arpitkatiyarprojects.countrypicker.models.CountriesListDialogProperties
import com.arpitkatiyarprojects.countrypicker.models.CountryDetails
import com.arpitkatiyarprojects.countrypicker.models.Dimensions
import com.arpitkatiyarprojects.countrypicker.models.SelectedCountryProperties
import com.arpitkatiyarprojects.countrypickerproject.ui.common.CountryDetailsSectionRow
import com.arpitkatiyarprojects.countrypickerproject.ui.common.SpacerHeight16
import com.arpitkatiyarprojects.countrypickerproject.ui.common.SpacerHeight4
import com.arpitkatiyarprojects.countrypickerproject.ui.common.TextProgressRow
import com.arpitkatiyarprojects.countrypickerproject.ui.common.TextSwitchRow
import com.arpitkatiyarprojects.countrypickerproject.ui.common.TextWidthHeightRow
import com.arpitkatiyarprojects.countrypickerproject.ui.common.TitleSettingsComposable

@Composable
fun CountryPickerWithoutOutlinedText() {
    val showSelectedCountryFlagState = remember {
        mutableStateOf(true)
    }
    val showSelectedCountryPhoneCodeState = remember {
        mutableStateOf(true)
    }
    val showSelectedCountryNameState = remember {
        mutableStateOf(false)
    }
    val showSelectedCountryCodeState = remember {
        mutableStateOf(false)
    }
    val spaceAfterSelectedCountryFlagMutableState = remember {
        mutableStateOf(8.dp)
    }
    val spaceAfterSelectedCountryPhoneCode = remember {
        mutableStateOf(6.dp)
    }
    val spaceAfterSelectedCountryName = remember {
        mutableStateOf(6.dp)
    }
    val spaceAfterSelectedCountryCode = remember {
        mutableStateOf(6.dp)
    }

    val selectedCountryFlagWidthState = remember {
        mutableStateOf(28.dp)
    }
    val selectedCountryFlagHeightState = remember {
        mutableStateOf(18.dp)
    }
    val selectedCountryState: MutableState<CountryDetails?> = remember {
        mutableStateOf(null)
    }

    val countryListFlagWidthState = remember {
        mutableStateOf(30.dp)
    }
    val countryListFlagHeightState = remember {
        mutableStateOf(20.dp)
    }
    val countryListShowCountryCode = remember {
        mutableStateOf(false)
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .animateContentSize()
    ) {
        CountryPicker(
            modifier = Modifier
                .padding(16.dp),
            selectedCountryProperties = SelectedCountryProperties(
                showSelectedCountryFlagState.value,
                showSelectedCountryPhoneCodeState.value,
                showSelectedCountryNameState.value,
                showSelectedCountryCodeState.value,
                spaceAfterSelectedCountryFlagMutableState.value,
                spaceAfterSelectedCountryPhoneCode.value,
                spaceAfterSelectedCountryName.value,
                spaceAfterSelectedCountryCode.value
            ),
            selectedCountryFlagDimensions = Dimensions(
                selectedCountryFlagWidthState.value,
                selectedCountryFlagHeightState.value
            ),
            countriesListDialogProperties = CountriesListDialogProperties(countryListShowCountryCode.value),
            countriesListDialogFlagDimensions = Dimensions(
                countryListFlagWidthState.value,
                countryListFlagHeightState.value
            )
        ) {
            selectedCountryState.value = it
        }
        SpacerHeight16()
        CountryDetailsSectionRow(
            selectedCountryState.value,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        SpacerHeight16()
        TitleSettingsComposable("Selected Country Settings:- ") {
            SelectedCountrySettings(
                selectedCountryFlagWidthState,
                selectedCountryFlagHeightState,
                showSelectedCountryFlagState,
                showSelectedCountryPhoneCodeState,
                showSelectedCountryNameState,
                showSelectedCountryCodeState,
                spaceAfterSelectedCountryFlagMutableState,
                spaceAfterSelectedCountryPhoneCode,
                spaceAfterSelectedCountryName,
                spaceAfterSelectedCountryCode
            )
        }
        TitleSettingsComposable("Countries List Dialog Settings:- ") {
            CountriesListDialogSettings(
                countryListFlagWidthState,
                countryListFlagHeightState,
                countryListShowCountryCode
            )
        }
    }
}

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