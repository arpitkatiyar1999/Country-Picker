package com.arpitkatiyarprojects.countrypickerproject.ui.country_picker_demo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arpitkatiyarprojects.countrypicker.CountryPicker
import com.arpitkatiyarprojects.countrypicker.models.CountriesListDialogDisplayProperties
import com.arpitkatiyarprojects.countrypicker.models.CountriesListDialogProperties
import com.arpitkatiyarprojects.countrypicker.models.CountryDetails
import com.arpitkatiyarprojects.countrypicker.models.FlagDimensions
import com.arpitkatiyarprojects.countrypicker.models.SelectedCountryDisplayProperties
import com.arpitkatiyarprojects.countrypicker.models.SelectedCountryProperties
import com.arpitkatiyarprojects.countrypickerproject.ui.common.CountriesListDialogSettings
import com.arpitkatiyarprojects.countrypickerproject.ui.common.CountryDetailsSectionRow
import com.arpitkatiyarprojects.countrypickerproject.ui.common.SelectedCountrySettings
import com.arpitkatiyarprojects.countrypickerproject.ui.common.SpacerHeight16
import com.arpitkatiyarprojects.countrypickerproject.ui.common.TitleSettingsComposable

@Composable
fun CountryPickerWithoutTextField() {
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

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            CountryPicker(
                modifier = Modifier
                    .padding(16.dp),
                selectedCountryDisplayProperties = SelectedCountryDisplayProperties(
                    properties = SelectedCountryProperties(
                        showSelectedCountryFlagState.value,
                        showSelectedCountryPhoneCodeState.value,
                        showSelectedCountryNameState.value,
                        showSelectedCountryCodeState.value,
                        spaceAfterSelectedCountryFlagMutableState.value,
                        spaceAfterSelectedCountryPhoneCode.value,
                        spaceAfterSelectedCountryName.value,
                        spaceAfterSelectedCountryCode.value
                    ),
                    flagDimensions = FlagDimensions(
                        selectedCountryFlagWidthState.value,
                        selectedCountryFlagHeightState.value
                    )
                ),
                countriesListDialogDisplayProperties = CountriesListDialogDisplayProperties(
                    properties = CountriesListDialogProperties(
                        countryListShowCountryCode.value
                    ),
                    flagDimensions = FlagDimensions(
                        countryListFlagWidthState.value,
                        countryListFlagHeightState.value
                    )
                ),
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
}

