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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.arpitkatiyarprojects.countrypicker.enums.CountryListDisplayType
import com.arpitkatiyarprojects.countrypicker.models.CountriesListDialogDisplayProperties
import com.arpitkatiyarprojects.countrypicker.models.CountryDetails
import com.arpitkatiyarprojects.countrypicker.models.SelectedCountryDisplayProperties
import com.arpitkatiyarprojects.countrypicker.utils.FunctionHelper


/**
 * Displays the country picker without any text field.
 * @param modifier the [Modifier] to be applied to this text field.
 * @param defaultPaddingValues The The [PaddingValues] to apply internally between the container and the content.
 * @param selectedCountryDisplayProperties The [SelectedCountryDisplayProperties] properties related to the selected country display, including flag dimensions and text styles.
 * @param countriesListDialogDisplayProperties The [CountriesListDialogDisplayProperties] properties related to the country selection dialog, including flag dimensions and text styles.
 * @param defaultCountryCode  Specifies the default country code to be pre-selected in the picker. The code must adhere to the 2-letter ISO standard. For example, "in" represents India. If not explicitly provided, the picker will automatically detect the user's country.
 * @param countriesList Specifies a list of countries to populate in the picker. If not provided, the picker will use a predefined list of countries. It's essential that the provided countries list strictly adheres to the standard 2-letter ISO code format for each country.
 * @param onCountrySelected The callback function is triggered each time a country is selected within the picker. Additionally, it is also invoked when the picker is first displayed on the screen with the default selected country.
 */
@Composable
fun CountryPicker(
    modifier: Modifier = Modifier,
    defaultPaddingValues: PaddingValues = PaddingValues(4.dp, 6.dp),
    selectedCountryDisplayProperties: SelectedCountryDisplayProperties = SelectedCountryDisplayProperties(),
    countriesListDialogDisplayProperties: CountriesListDialogDisplayProperties = CountriesListDialogDisplayProperties(),
    defaultCountryCode: String? = null,
    countriesList: List<String>? = null,
    countryListDisplayType: CountryListDisplayType = CountryListDisplayType.Dialog,
    onCountrySelected: (country: CountryDetails) -> Unit
) {
    val context = LocalContext.current
    var openCountrySelectionList by remember { mutableStateOf(false) }
    val applicableCountriesList = remember {
        val allCountriesList = FunctionHelper.getAllCountries(context)
        if (countriesList.isNullOrEmpty()) {
            allCountriesList
        } else {
            val updatedCountriesList = countriesList.map { it.lowercase() }
            allCountriesList.filter { it.countryCode in updatedCountriesList }
        }
    }
    var selectedCountry by remember {
        mutableStateOf(
            FunctionHelper.getDefaultSelectedCountry(
                context,
                defaultCountryCode?.lowercase(),
                applicableCountriesList
            ).also {
                onCountrySelected(it)
            }
        )
    }
    if (openCountrySelectionList) {
        CountrySelectionList(
            countriesList = applicableCountriesList,
            countriesListDialogDisplayProperties = countriesListDialogDisplayProperties,
            countryListDisplayType = countryListDisplayType,
            onDismissRequest = {
                openCountrySelectionList = false
            },
            onSelected = { country ->
                selectedCountry = country
                openCountrySelectionList = false
                onCountrySelected(country)
            },
        )
    }
    SelectedCountrySection(
        defaultPaddingValues = defaultPaddingValues,
        selectedCountry = selectedCountry,
        selectedCountryDisplayProperties = selectedCountryDisplayProperties,
        modifier = modifier
    ) {
        openCountrySelectionList = !openCountrySelectionList
    }
}


/**
 * A composable function that displays information about the selected country in a row format,
 * with options to show or hide various country attributes like the flag, phone code, name, and ISO code.
 * @param selectedCountryDisplayProperties The [SelectedCountryDisplayProperties] properties related to the selected country display, including flag dimensions and text styles.
 * @param defaultPaddingValues Padding values applied to the Row container for the section.
 * @param selectedCountry The details of the selected country, encapsulated in a `CountryDetails` object.
 * @param modifier Modifier applied to the Row, allowing for customization of its appearance and behavior.
 * @param onSelectCountry A callback function triggered when the user clicks on the Row, used to handle the selection event.
 */
@Composable
private fun SelectedCountrySection(
    defaultPaddingValues: PaddingValues,
    selectedCountry: CountryDetails,
    selectedCountryDisplayProperties: SelectedCountryDisplayProperties,
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
        with(selectedCountryDisplayProperties) {
            if (properties.showCountryFlag) {
                Image(
                    modifier = Modifier
                        .width(flagDimensions.width)
                        .height(flagDimensions.height),
                    painter = painterResource(selectedCountry.countryFlag),
                    contentScale = ContentScale.Crop,
                    contentDescription = selectedCountry.countryName
                )
                Spacer(modifier = Modifier.width(properties.spaceAfterCountryFlag))
            }
            if (properties.showCountryPhoneCode) {
                Text(
                    text = selectedCountry.countryPhoneNumberCode,
                    style = textStyles.countryPhoneCodeTextStyle
                )
                Spacer(modifier = Modifier.width(properties.spaceAfterCountryPhoneCode))
            }
            if (properties.showCountryName) {
                Text(
                    text = selectedCountry.countryName,
                    style = textStyles.countryNameTextStyle
                )
                Spacer(modifier = Modifier.width(properties.spaceAfterCountryName))
            }
            if (properties.showCountryCode) {
                Text(
                    text = selectedCountry.countryCode.uppercase(),
                    style = textStyles.countryCodeTextStyle
                )
                Spacer(modifier = Modifier.width(properties.spaceAfterCountryCode))
            }
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = stringResource(R.string.select_country_dropdown)
            )
        }
    }
}