package com.arpitkatiyarprojects.countrypickerproject.ui.country_picker_demo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arpitkatiyarprojects.countrypicker.CountryPickerOutlinedTextField
import com.arpitkatiyarprojects.countrypicker.models.BorderThickness
import com.arpitkatiyarprojects.countrypicker.models.CountryDetails
import com.arpitkatiyarprojects.countrypicker.models.SelectedCountryProperties
import com.arpitkatiyarprojects.countrypicker.utils.CountryPickerUtils
import com.arpitkatiyarprojects.countrypickerproject.ui.common.CountryDetailsSectionRow
import com.arpitkatiyarprojects.countrypickerproject.ui.common.SpacerHeight16
import com.arpitkatiyarprojects.countrypickerproject.ui.common.SpacerHeight4
import com.arpitkatiyarprojects.countrypickerproject.ui.common.TextProgressRow
import com.arpitkatiyarprojects.countrypickerproject.ui.common.TextSwitchRow
import com.arpitkatiyarprojects.countrypickerproject.ui.common.TextWidthHeightRow


@Composable
fun CountryPickerWithOutlinedText() {
    val showCountryFlagState = remember {
        mutableStateOf(true)
    }
    val showCountryPhoneCodeState = remember {
        mutableStateOf(true)
    }
    val showCountryNameState = remember {
        mutableStateOf(false)
    }
    val showCountryCodeState = remember {
        mutableStateOf(false)
    }
    val spaceAfterCountryFlagMutableState = remember {
        mutableStateOf(8.dp)
    }
    val spaceAfterCountryPhoneCode = remember {
        mutableStateOf(6.dp)
    }
    val spaceAfterCountryName = remember {
        mutableStateOf(6.dp)
    }
    val spaceAfterCountryCode = remember {
        mutableStateOf(6.dp)
    }

    val flagWidthState = remember {
        mutableStateOf(28.dp)
    }
    val flagHeightState = remember {
        mutableStateOf(18.dp)
    }
    val selectedCountryState: MutableState<CountryDetails?> = remember {
        mutableStateOf(null)
    }
    var mobileNumber by remember {
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        CountryPickerOutlinedTextField(
            isError = isMobileNumberValidationError,
            supportingText = {
                if (isMobileNumberValidationError) {
                    Text(text = "Invalid mobile number")
                }
            },
            modifier = Modifier.fillMaxWidth(),
            mobileNumber = CountryPickerUtils.getFormattedMobileNumber(
                selectedCountryState.value?.countryCode ?: "IN", mobileNumber
            ),
            onMobileNumberChange = {
                mobileNumber = it
                isMobileNumberValidationError = !CountryPickerUtils.isMobileNumberValid(
                    mobileNumber,
                    selectedCountryState.value?.countryCode ?: "IN"
                )
            },
            placeholder = {
                Text(
                    text = CountryPickerUtils.getExampleMobileNumber(
                        selectedCountryState.value?.countryCode ?: "IN"
                    )
                )
            },
            onCountrySelected = {
                selectedCountryState.value = it
            },
            selectedCountryProperties = SelectedCountryProperties(
                showCountryFlagState.value,
                showCountryPhoneCodeState.value,
                showCountryNameState.value,
                showCountryCodeState.value,
                spaceAfterCountryFlagMutableState.value,
                spaceAfterCountryPhoneCode.value,
                spaceAfterCountryName.value,
                spaceAfterCountryCode.value
            ),
            //countryFlagDimensions = Dimensions(flagWidthState.value, flagHeightState.value),
            borderThickness = BorderThickness(
                focusedBorderThickness.value,
                unfocusedBorderThickness.value
            )
        )
        SpacerHeight16()
        CountryDetailsSectionRow(selectedCountryState.value)
        SpacerHeight16()
        TextWidthHeightRow(flagWidthState, flagHeightState)
        SpacerHeight4()
        TextSwitchRow(text = "Show Country Flag", showCountryFlagState)
        SpacerHeight4()
        TextSwitchRow(text = "Show Country Phone Code", showCountryPhoneCodeState)
        SpacerHeight4()
        TextSwitchRow(text = "Show Country Name", showCountryNameState)
        SpacerHeight4()
        TextSwitchRow(text = "Show Country Code", showCountryCodeState)
        SpacerHeight4()
        TextProgressRow(
            text = "Space After Country Flag",
            valueChangeMutableState = spaceAfterCountryFlagMutableState
        )
        SpacerHeight4()
        TextProgressRow(
            text = "Space After Country Phone Code",
            valueChangeMutableState = spaceAfterCountryPhoneCode
        )
        SpacerHeight4()
        TextProgressRow(
            text = "Space After Country Name",
            valueChangeMutableState = spaceAfterCountryName
        )
        SpacerHeight4()
        TextProgressRow(
            text = "Space After Country Code",
            valueChangeMutableState = spaceAfterCountryCode
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
