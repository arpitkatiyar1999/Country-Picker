package com.arpitkatiyarprojects.countrypickerproject.ui.country_picker_demo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.arpitkatiyarprojects.countrypicker.CountryPickerOutlinedTextField
import com.arpitkatiyarprojects.countrypicker.models.BorderThickness
import com.arpitkatiyarprojects.countrypicker.models.CountriesListDialogDisplayProperties
import com.arpitkatiyarprojects.countrypicker.models.CountriesListDialogProperties
import com.arpitkatiyarprojects.countrypicker.models.CountryDetails
import com.arpitkatiyarprojects.countrypicker.models.FlagDimensions
import com.arpitkatiyarprojects.countrypicker.models.SelectedCountryDisplayProperties
import com.arpitkatiyarprojects.countrypicker.models.SelectedCountryProperties
import com.arpitkatiyarprojects.countrypicker.utils.CountryPickerUtils
import com.arpitkatiyarprojects.countrypickerproject.ui.common.CountriesListDialogSettings
import com.arpitkatiyarprojects.countrypickerproject.ui.common.CountryDetailsSectionRow
import com.arpitkatiyarprojects.countrypickerproject.ui.common.SelectedCountrySettings
import com.arpitkatiyarprojects.countrypickerproject.ui.common.SpacerHeight16
import com.arpitkatiyarprojects.countrypickerproject.ui.common.SpacerHeight4
import com.arpitkatiyarprojects.countrypickerproject.ui.common.TextProgressRow
import com.arpitkatiyarprojects.countrypickerproject.ui.common.TextSwitchRow
import com.arpitkatiyarprojects.countrypickerproject.ui.common.TitleSettingsComposable


@Composable
fun CountryPickerWithOutlinedText() {
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

    var enteredMobileNumber by remember {
        mutableStateOf("")
    }
    val unfocusedBorderThickness = remember {
        mutableStateOf(2.dp)
    }

    val focusedBorderThickness = remember {
        mutableStateOf(1.dp)
    }

    var isMobileNumberValidationError by remember {
        mutableStateOf(false)
    }

    val formatExampleMobileNumberState = remember {
        mutableStateOf(false)
    }
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            CountryPickerOutlinedTextField(
                isError = isMobileNumberValidationError,
                supportingText = {
                    if (isMobileNumberValidationError) {
                        Text(text = "Invalid mobile number")
                    } else if (enteredMobileNumber.isNotBlank()) {
                        Text(text = "Valid mobile number")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                mobileNumber = CountryPickerUtils.getFormattedMobileNumber(
                    enteredMobileNumber, selectedCountryState.value?.countryCode ?: "IN",
                ),
                onMobileNumberChange = {
                    enteredMobileNumber = it
                    isMobileNumberValidationError = !CountryPickerUtils.isMobileNumberValid(
                        enteredMobileNumber,
                        selectedCountryState.value?.countryCode ?: "IN"
                    )
                },
                placeholder = {
                    Text(
                        text = "for eg. ${
                            CountryPickerUtils.getExampleMobileNumber(
                                selectedCountryState.value?.countryCode ?: "IN",
                                formatExampleMobileNumberState.value
                            )
                        }"
                    )
                },
                onCountrySelected = {
                    selectedCountryState.value = it
                },
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
                borderThickness = BorderThickness(
                    focusedBorderThickness.value,
                    unfocusedBorderThickness.value
                ),
                colors = TextFieldDefaults.colors(focusedSupportingTextColor = Color(0xFF2eb82e))
            )
            CountryDetailsSectionRow(
                selectedCountryState.value,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            SpacerHeight16()
            TitleSettingsComposable("Selected Country Settings:- ") {
                Column {
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
                    SpacerHeight4()
                    TextSwitchRow(
                        text = "Format Example Mobile Number",
                        formatExampleMobileNumberState
                    )
                    SpacerHeight4()
                    TextProgressRow(
                        text = "Unfocused Border Thickness",
                        valueChangeMutableState = unfocusedBorderThickness
                    )
                    SpacerHeight4()
                    TextProgressRow(
                        text = "Focused Border Thickness",
                        valueChangeMutableState = focusedBorderThickness
                    )
                }

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
