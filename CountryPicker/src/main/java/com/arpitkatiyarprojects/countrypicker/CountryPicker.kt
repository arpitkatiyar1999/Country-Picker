package com.arpitkatiyarprojects.countrypicker

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.arpitkatiyarprojects.countrypicker.models.CountryDetails
import com.arpitkatiyarprojects.countrypicker.models.CountryPickerProperties
import com.arpitkatiyarprojects.countrypicker.models.Dimensions
import com.arpitkatiyarprojects.countrypicker.models.PickerTextStyles
import com.arpitkatiyarprojects.countrypicker.utils.FunctionHelper


/**
 * Displays the country picker without any outlined text field.
 * @param modifier the Modifier to be applied to this text field.
 * @param defaultPaddingValues The spacing values to apply internally between the container and the content
 * @param countryPickerProperties Defines the configurations for the CountryPicker
 * @param countryFlagDimensions Defines the dimensions for the country flags displayed within the picker.
 * @param pickerTextStyles  Defines the text styles for the picker items.
 * @param defaultCountryCode  Specifies the default country code to be pre-selected in the picker. The code must adhere to the 2-letter ISO standard. For example, "in" represents India. If not explicitly provided, the picker will automatically detect the user's country.
 * @param countriesList Specifies a list of countries to populate in the picker. If not provided, the picker will use a predefined list of countries. It's essential that the provided countries list strictly adheres to the standard 2-letter ISO code format for each country.
 * @param onCountrySelected The callback function is triggered each time a country is selected within the picker. Additionally, it is also invoked when the picker is first displayed on the screen with the default selected country.
 */
@Composable
fun CountryPicker(
    modifier: Modifier = Modifier,
    defaultPaddingValues: PaddingValues = PaddingValues(4.dp, 6.dp),
    countryPickerProperties: CountryPickerProperties = CountryPickerProperties(),
    countryFlagDimensions: Dimensions = Dimensions(),
    pickerTextStyles: PickerTextStyles = PickerTextStyles(),
    defaultCountryCode: String? = null,
    countriesList: List<String>? = null,
    onCountrySelected: (country: CountryDetails) -> Unit
) {

    val context = LocalContext.current
    var openCountrySelectionDialog by remember { mutableStateOf(false) }
    val countryList = remember {
        if (countriesList.isNullOrEmpty()) {
            FunctionHelper.getAllCountries(context)
        } else {
            val updatedCountriesList = countriesList.map { it.lowercase() }
            FunctionHelper.getAllCountries(context)
                .filter { updatedCountriesList.contains(it.countryCode) }
        }
    }
    var selectedCountry by remember {
        val selectedCountry =
            FunctionHelper.getDefaultSelectedCountry(
                context,
                defaultCountryCode?.lowercase(),
                countryList
            )
        onCountrySelected(selectedCountry)
        mutableStateOf(selectedCountry)
    }
    if (openCountrySelectionDialog) {
        CountrySelectionDialog(
            countryList = countryList,
            onDismissRequest = {
                openCountrySelectionDialog = false
            },
            onSelected = { country ->
                selectedCountry = country
                openCountrySelectionDialog = false
                onCountrySelected(country)
            },
        )
    }
    SelectedCountrySection(
        defaultPaddingValues = defaultPaddingValues,
        selectedCountry = selectedCountry,
        countryPickerProperties = countryPickerProperties,
        countryFlagDimensions = countryFlagDimensions,
        pickerTextStyles = pickerTextStyles,
        modifier = modifier
    ) {
        openCountrySelectionDialog = !openCountrySelectionDialog
    }
}

@Composable
private fun SelectedCountrySection(
    defaultPaddingValues: PaddingValues,
    selectedCountry: CountryDetails,
    countryPickerProperties: CountryPickerProperties,
    countryFlagDimensions: Dimensions,
    pickerTextStyles: PickerTextStyles,
    modifier: Modifier = Modifier,
    onSelectCountry: () -> Unit,
) {
    Row(
        modifier = modifier
            .clickable {
                onSelectCountry()
            }
            .padding(defaultPaddingValues),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (countryPickerProperties.showCountryFlag) {
            Image(
                modifier = Modifier
                    .width(countryFlagDimensions.width)
                    .height(countryFlagDimensions.height),
                painter = painterResource(selectedCountry.countryFlag),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(countryPickerProperties.spaceAfterCountryFlag))
        }
        if (countryPickerProperties.showCountryPhoneCode) {
            Text(
                text = selectedCountry.countryPhoneNumberCode,
                style = pickerTextStyles.countryPhoneCodeTextStyle
            )
            Spacer(modifier = Modifier.width(countryPickerProperties.spaceAfterCountryPhoneCode))
        }
        if (countryPickerProperties.showCountryName) {
            Text(
                text = selectedCountry.countryName,
                style = pickerTextStyles.countryNameTextStyle
            )
            Spacer(modifier = Modifier.width(countryPickerProperties.spaceAfterCountryName))
        }
        if (countryPickerProperties.showCountryCode) {
            Text(
                text = selectedCountry.countryCode.uppercase(),
                style = pickerTextStyles.countryCodeTextStyle
            )
            Spacer(modifier = Modifier.width(countryPickerProperties.spaceAfterCountryCode))
        }
        Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
    }
}