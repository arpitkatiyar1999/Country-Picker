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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.arpitkatiyarprojects.countrypicker.CountryPickerOutlinedTextField
import com.arpitkatiyarprojects.countrypicker.models.BorderThickness
import com.arpitkatiyarprojects.countrypicker.models.CountriesListDialogDisplayProperties
import com.arpitkatiyarprojects.countrypicker.models.CountryDetails
import com.arpitkatiyarprojects.countrypicker.models.SelectedCountryDisplayProperties
import com.arpitkatiyarprojects.countrypicker.utils.CountryPickerUtils
import com.arpitkatiyarprojects.countrypickerproject.ui.common.CountriesListDialogSettings
import com.arpitkatiyarprojects.countrypickerproject.ui.common.CountryDetailsSectionRow
import com.arpitkatiyarprojects.countrypickerproject.ui.common.SelectedCountrySettings
import com.arpitkatiyarprojects.countrypickerproject.ui.common.SpacerHeight8
import com.arpitkatiyarprojects.countrypickerproject.ui.common.TextProgressRow
import com.arpitkatiyarprojects.countrypickerproject.ui.common.TextSwitchRow
import com.arpitkatiyarprojects.countrypickerproject.ui.common.TitleSettingsComposable


@Composable
fun CountryPickerWithOutlinedText() {
    var selectedCountryDisplayProperties by remember {
        mutableStateOf(SelectedCountryDisplayProperties())
    }

    var countriesListDialogDisplayProperties by remember {
        mutableStateOf(CountriesListDialogDisplayProperties())
    }

    var borderThickness by remember {
        mutableStateOf(BorderThickness())
    }

    var selectedCountryState by remember {
        mutableStateOf<CountryDetails?>(null)
    }

    var formatExampleMobileNumber by remember {
        mutableStateOf(false)
    }

    var enteredMobileNumber by remember {
        mutableStateOf("")
    }

    var isMobileNumberValidationError by remember {
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
                supportingText = if (isMobileNumberValidationError || enteredMobileNumber.isNotBlank()) {
                    {
                        Text(text = if (isMobileNumberValidationError) "Invalid mobile number" else "Valid mobile number")
                    }
                } else null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                mobileNumber = enteredMobileNumber,
                onMobileNumberChange = {
                    enteredMobileNumber = it
                    isMobileNumberValidationError = !CountryPickerUtils.isMobileNumberValid(
                        enteredMobileNumber,
                        selectedCountryState?.countryCode ?: "IN"
                    )
                },
                placeholder = {
                    Text(
                        text = "eg. ${
                            CountryPickerUtils.getExampleMobileNumber(
                                selectedCountryState?.countryCode ?: "IN",
                                formatExampleMobileNumber
                            )
                        }"
                    )
                },
                onCountrySelected = {
                    selectedCountryState = it
                },
                selectedCountryDisplayProperties = selectedCountryDisplayProperties,
                countriesListDialogDisplayProperties = countriesListDialogDisplayProperties,
                borderThickness = borderThickness,
                colors = TextFieldDefaults.colors(
                    focusedSupportingTextColor = Color(0xFF2eb82e),
                    unfocusedPlaceholderColor = Color.Gray,
                    focusedPlaceholderColor = Color.Gray,
                    errorPlaceholderColor = Color.Gray,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    errorContainerColor = Color.Transparent,
                    focusedTextColor = Color.Black,
                ),
                textStyle = TextStyle.Default.copy(fontWeight = FontWeight.SemiBold),
            )
            CountryDetailsSectionRow(selectedCountryState)
            TitleSettingsComposable("Selected Country Settings:- ") {
                Column {
                    SelectedCountrySettings(selectedCountryDisplayProperties) {
                        selectedCountryDisplayProperties = it
                    }

                    TextSwitchRow(
                        text = "Format Example Mobile Number",
                        formatExampleMobileNumber
                    ) {
                        formatExampleMobileNumber = it
                    }

                    TextProgressRow(
                        text = "Unfocused Border Thickness",
                        currentProgress = borderThickness.unfocusedBorderThickness
                    ) {
                        borderThickness = borderThickness.copy(unfocusedBorderThickness = it)
                    }

                    TextProgressRow(
                        text = "Focused Border Thickness",
                        currentProgress = borderThickness.focusedBorderThickness
                    ) {
                        borderThickness = borderThickness.copy(focusedBorderThickness = it)
                    }
                }

            }
            SpacerHeight8()
            TitleSettingsComposable("Countries List Dialog Settings:- ") {
                CountriesListDialogSettings(countriesListDialogDisplayProperties) {
                    countriesListDialogDisplayProperties = it
                }
            }
        }
    }
}
