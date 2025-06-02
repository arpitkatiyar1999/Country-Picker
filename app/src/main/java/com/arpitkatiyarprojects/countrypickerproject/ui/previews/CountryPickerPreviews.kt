package com.arpitkatiyarprojects.countrypickerproject.ui.previews

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.arpitkatiyarprojects.countrypicker.CountryPicker
import com.arpitkatiyarprojects.countrypicker.models.SelectedCountryDisplayProperties
import com.arpitkatiyarprojects.countrypicker.models.SelectedCountryProperties

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CountryPickerPreview_FlagNames() {
    MyPreview {
        Column {
            listOf(
                "in",// Default
                "tt",// Special characters
                "vc",// Special characters & very long name
                "sh",// Longest name
            ).forEach { countryName ->
                CountryPicker(
                    selectedCountryDisplayProperties = SelectedCountryDisplayProperties(
                        properties = SelectedCountryProperties(
                            showCountryName = true,
                        ),
                    ),
                    defaultCountryCode = countryName,
                    onCountrySelected = {},
                )
            }
        }
    }
}
