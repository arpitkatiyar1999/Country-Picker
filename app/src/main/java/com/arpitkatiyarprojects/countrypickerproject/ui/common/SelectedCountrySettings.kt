package com.arpitkatiyarprojects.countrypickerproject.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arpitkatiyarprojects.countrypicker.models.SelectedCountryDisplayProperties

@Composable
fun SelectedCountrySettings(
    selectedCountryDisplayProperties: SelectedCountryDisplayProperties,
    onPropertiesChange: (SelectedCountryDisplayProperties) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        with(selectedCountryDisplayProperties) {
            TextWidthHeightRow(flagDimensions) {
                onPropertiesChange(copy(flagDimensions = it))
            }

            TextSwitchRow(text = "Show Country Flag", properties.showCountryFlag) {
                val updatedProperties = properties.copy(showCountryFlag = it)
                onPropertiesChange(copy(properties = updatedProperties))
            }

            TextSwitchRow(text = "Show Country Phone Code", properties.showCountryPhoneCode) {
                val updatedProperties = properties.copy(showCountryPhoneCode = it)
                onPropertiesChange(copy(properties = updatedProperties))
            }

            TextSwitchRow(text = "Show Country Name", properties.showCountryName) {
                val updatedProperties = properties.copy(showCountryName = it)
                onPropertiesChange(copy(properties = updatedProperties))
            }

            TextSwitchRow(text = "Show Country Code", properties.showCountryCode) {
                val updatedProperties = properties.copy(showCountryCode = it)
                onPropertiesChange(copy(properties = updatedProperties))
            }

            TextProgressRow(
                text = "Space After Country Flag",
                currentProgress = properties.spaceAfterCountryFlag
            ) {
                val updatedProperties = properties.copy(spaceAfterCountryFlag = it)
                onPropertiesChange(copy(properties = updatedProperties))
            }

            TextProgressRow(
                text = "Space After Country Phone Code",
                currentProgress = properties.spaceAfterCountryPhoneCode
            ) {
                val updatedProperties = properties.copy(spaceAfterCountryPhoneCode = it)
                onPropertiesChange(copy(properties = updatedProperties))
            }

            TextProgressRow(
                text = "Space After Country Name",
                currentProgress = properties.spaceAfterCountryName
            ) {
                val updatedProperties = properties.copy(spaceAfterCountryName = it)
                onPropertiesChange(copy(properties = updatedProperties))
            }

            TextProgressRow(
                text = "Space After Country Code",
                currentProgress = properties.spaceAfterCountryCode,
            ) {
                val updatedProperties = properties.copy(spaceAfterCountryCode = it)
                onPropertiesChange(copy(properties = updatedProperties))
            }
        }
    }
}