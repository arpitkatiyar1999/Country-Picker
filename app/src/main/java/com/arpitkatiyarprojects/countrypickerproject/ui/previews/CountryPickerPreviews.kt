package com.arpitkatiyarprojects.countrypickerproject.ui.previews

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.arpitkatiyarprojects.countrypicker.CountryPicker
import com.arpitkatiyarprojects.countrypicker.DefaultDropDownIcon
import com.arpitkatiyarprojects.countrypicker.R
import com.arpitkatiyarprojects.countrypicker.models.SelectedCountryDisplayProperties
import com.arpitkatiyarprojects.countrypicker.models.SelectedCountryProperties

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CountryPickerPreview_CustomDropDownIcon() {
    MyPreview {
        Column {
            CountryPicker(
                defaultCountryCode = "in",
                onCountrySelected = {},
                dropDownIcon = { isPickerEnabled, countryPickerColors ->
                    // Allow access to the default composable, in case the custom view is optional
                    DefaultDropDownIcon()
                },
            )
            CountryPicker(
                defaultCountryCode = "in",
                onCountrySelected = {},
                dropDownIcon = { isPickerEnabled, countryPickerColors ->
                    // Easy example as preview. A checkmark doesn't make sense of course!
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = stringResource(R.string.select_country_dropdown),
                        tint = if (isPickerEnabled) countryPickerColors.dropDownIconColor else countryPickerColors.dropDownDisabledIconColor,
                    )
                }
            )
        }
    }
}

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
