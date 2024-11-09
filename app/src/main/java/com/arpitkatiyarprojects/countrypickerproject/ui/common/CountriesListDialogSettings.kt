package com.arpitkatiyarprojects.countrypickerproject.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arpitkatiyarprojects.countrypicker.models.CountriesListDialogDisplayProperties

@Composable
fun CountriesListDialogSettings(
    countriesListDialogDisplayProperties: CountriesListDialogDisplayProperties,
    onPropertiesChange: (CountriesListDialogDisplayProperties) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        with(countriesListDialogDisplayProperties) {
            TextWidthHeightRow(flagDimensions) { updatedDimensions ->
                onPropertiesChange(copy(flagDimensions = updatedDimensions))
            }
            TextSwitchRow(
                text = "Show Country Code",
                properties.showCountryCode
            ) {
                val updatedProperties = properties.copy(showCountryCode = it)
                onPropertiesChange(copy(properties = updatedProperties))
            }
        }
    }
}