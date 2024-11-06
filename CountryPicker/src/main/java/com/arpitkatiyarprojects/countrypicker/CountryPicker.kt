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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.arpitkatiyarprojects.countrypicker.models.CountriesListDialogProperties
import com.arpitkatiyarprojects.countrypicker.models.CountryDetails
import com.arpitkatiyarprojects.countrypicker.models.CountryPickerTextStyles
import com.arpitkatiyarprojects.countrypicker.models.Dimensions
import com.arpitkatiyarprojects.countrypicker.models.SelectedCountryProperties
import com.arpitkatiyarprojects.countrypicker.utils.FunctionHelper


@Composable
fun CountryPicker(
    modifier: Modifier = Modifier,
    defaultPaddingValues: PaddingValues = PaddingValues(4.dp, 6.dp),
    selectedCountryProperties: SelectedCountryProperties = SelectedCountryProperties(),
    selectedCountryFlagDimensions: Dimensions = Dimensions(width = 28.dp, height = 18.dp),
    selectedCountryTextStyles: CountryPickerTextStyles = CountryPickerTextStyles(
        countryPhoneCodeTextStyle = TextStyle(fontWeight = FontWeight.Bold),
        countryNameTextStyle = TextStyle(),
        countryCodeTextStyle = TextStyle()
    ),
    countriesListDialogProperties: CountriesListDialogProperties = CountriesListDialogProperties(),
    countriesListDialogFlagDimensions: Dimensions = Dimensions(width = 30.dp, height = 20.dp),
    countriesListDialogTextStyles: CountryPickerTextStyles = CountryPickerTextStyles(
        countryPhoneCodeTextStyle = MaterialTheme.typography.bodyMedium,
        countryNameTextStyle = MaterialTheme.typography.bodyMedium,
        countryCodeTextStyle = MaterialTheme.typography.bodyMedium
    ),
    defaultCountryCode: String? = null,
    countriesList: List<String>? = null,
    onCountrySelected: (country: CountryDetails) -> Unit
) {
    val context = LocalContext.current
    var openCountrySelectionDialog by rememberSaveable { mutableStateOf(false) }
    val countryList = rememberSaveable {
        if (countriesList.isNullOrEmpty()) {
            FunctionHelper.getAllCountries(context)
        } else {
            val updatedCountriesList = countriesList.map { it.lowercase() }
            FunctionHelper.getAllCountries(context)
                .filter { updatedCountriesList.contains(it.countryCode) }
        }
    }
    var selectedCountry by rememberSaveable {
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
            countriesList = countryList,
            countriesListDialogProperties = countriesListDialogProperties,
            countriesListDialogFlagDimensions = countriesListDialogFlagDimensions,
            countriesListDialogTextStyles = countriesListDialogTextStyles,
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
        selectedCountryProperties = selectedCountryProperties,
        selectedCountryFlagDimensions = selectedCountryFlagDimensions,
        selectedCountryTextStyles = selectedCountryTextStyles,
        modifier = modifier
    ) {
        openCountrySelectionDialog = !openCountrySelectionDialog
    }
}


/**
 * A composable function that displays information about the selected country in a row format,
 * with options to show or hide various country attributes like the flag, phone code, name, and ISO code.
 *
 * @param defaultPaddingValues Padding values applied to the Row container for the section.
 * @param selectedCountry The details of the selected country, encapsulated in a `CountryDetails` object.
 * @param selectedCountryProperties Properties controlling the visibility and spacing of the country details,
 *                                such as whether to show the flag, phone code, name, and country code.
 * @param selectedCountryFlagDimensions Specifies the width and height for the country flag image, encapsulated in a `Dimensions` object.
 * @param selectedCountryTextStyles Text styles for displaying different country details, encapsulated in a `PickerTextStyles` object.
 * @param modifier Modifier applied to the Row, allowing for customization of its appearance and behavior.
 * @param onSelectCountry A callback function triggered when the user clicks on the Row, used to handle the selection event.
 */
@Composable
private fun SelectedCountrySection(
    defaultPaddingValues: PaddingValues,
    selectedCountry: CountryDetails,
    selectedCountryProperties: SelectedCountryProperties,
    selectedCountryFlagDimensions: Dimensions,
    selectedCountryTextStyles: CountryPickerTextStyles,
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
        if (selectedCountryProperties.showCountryFlag) {
            Image(
                modifier = Modifier
                    .width(selectedCountryFlagDimensions.width)
                    .height(selectedCountryFlagDimensions.height),
                painter = painterResource(selectedCountry.countryFlag),
                contentScale = ContentScale.Crop,
                contentDescription = selectedCountry.countryName
            )
            Spacer(modifier = Modifier.width(selectedCountryProperties.spaceAfterCountryFlag))
        }
        if (selectedCountryProperties.showCountryPhoneCode) {
            Text(
                text = selectedCountry.countryPhoneNumberCode,
                style = selectedCountryTextStyles.countryPhoneCodeTextStyle
            )
            Spacer(modifier = Modifier.width(selectedCountryProperties.spaceAfterCountryPhoneCode))
        }
        if (selectedCountryProperties.showCountryName) {
            Text(
                text = selectedCountry.countryName,
                style = selectedCountryTextStyles.countryNameTextStyle
            )
            Spacer(modifier = Modifier.width(selectedCountryProperties.spaceAfterCountryName))
        }
        if (selectedCountryProperties.showCountryCode) {
            Text(
                text = selectedCountry.countryCode.uppercase(),
                style = selectedCountryTextStyles.countryCodeTextStyle
            )
            Spacer(modifier = Modifier.width(selectedCountryProperties.spaceAfterCountryCode))
        }
        Icon(
            imageVector = Icons.Default.ArrowDropDown,
            contentDescription = stringResource(R.string.select_country_dropdown)
        )
    }
}