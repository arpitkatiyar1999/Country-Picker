package com.arpitkatiyarprojects.countrypickerproject.ui.country_picker_demo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arpitkatiyarprojects.countrypicker.CountryPicker
import com.arpitkatiyarprojects.countrypicker.models.CountriesListDialogDisplayProperties
import com.arpitkatiyarprojects.countrypicker.models.CountryDetails
import com.arpitkatiyarprojects.countrypicker.models.SelectedCountryDisplayProperties
import com.arpitkatiyarprojects.countrypickerproject.ui.common.CountriesListDialogSettings
import com.arpitkatiyarprojects.countrypickerproject.ui.common.CountryDetailsSectionRow
import com.arpitkatiyarprojects.countrypickerproject.ui.common.SelectedCountrySettings
import com.arpitkatiyarprojects.countrypickerproject.ui.common.SpacerHeight16
import com.arpitkatiyarprojects.countrypickerproject.ui.common.SpacerHeight8
import com.arpitkatiyarprojects.countrypickerproject.ui.common.TitleSettingsComposable

@Composable
fun CountryPickerWithoutTextField() {

    var selectedCountryDisplayProperties by remember {
        mutableStateOf(SelectedCountryDisplayProperties())
    }

    var countriesListDialogDisplayProperties by remember {
        mutableStateOf(CountriesListDialogDisplayProperties())
    }

    var selectedCountryState by remember {
        mutableStateOf<CountryDetails?>(null)
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            SpacerHeight16()
            CountryPicker(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                selectedCountryDisplayProperties = selectedCountryDisplayProperties,
                countriesListDialogDisplayProperties = countriesListDialogDisplayProperties,
            ) {
                selectedCountryState = it
            }
            CountryDetailsSectionRow(selectedCountryState)
            TitleSettingsComposable("Selected Country Settings:- ") {
                SelectedCountrySettings(selectedCountryDisplayProperties) {
                    selectedCountryDisplayProperties = it
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

