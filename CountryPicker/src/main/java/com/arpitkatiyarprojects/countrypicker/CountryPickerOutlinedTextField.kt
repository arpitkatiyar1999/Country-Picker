package com.arpitkatiyarprojects.countrypicker

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.arpitkatiyarprojects.countrypicker.models.BorderThickness
import com.arpitkatiyarprojects.countrypicker.models.CountriesListDialogProperties
import com.arpitkatiyarprojects.countrypicker.models.CountryDetails
import com.arpitkatiyarprojects.countrypicker.models.CountryPickerDialogTextStyles
import com.arpitkatiyarprojects.countrypicker.models.Dimensions
import com.arpitkatiyarprojects.countrypicker.models.SelectedCountryProperties
import com.arpitkatiyarprojects.countrypicker.models.SelectedCountryTextStyles

@Composable
fun CountryPickerOutlinedTextField(
    mobileNumber: String,
    onMobileNumberChange: (String) -> Unit,
    onCountrySelected: (country: CountryDetails) -> Unit,
    modifier: Modifier = Modifier,
    defaultPaddingValues: PaddingValues = PaddingValues(4.dp, 6.dp),
    selectedCountryProperties: SelectedCountryProperties = SelectedCountryProperties(),
    selectedCountryFlagDimensions: Dimensions = Dimensions(width = 28.dp, height = 18.dp),
    selectedCountryTextStyles: SelectedCountryTextStyles = SelectedCountryTextStyles(),
    countriesListDialogProperties: CountriesListDialogProperties = CountriesListDialogProperties(),
    countriesListDialogFlagDimensions: Dimensions = Dimensions(width = 30.dp, height = 20.dp),
    countriesListDialogTextStyles: CountryPickerDialogTextStyles = CountryPickerDialogTextStyles.defaultTextStyles(),
    defaultCountryCode: String? = null,
    countriesList: List<String>? = null,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = RoundedCornerShape(12.dp),
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(),
    borderThickness: BorderThickness = BorderThickness(),
    onDone: (() -> Unit)? = null,
) {

    PickerOutlinedTextField(
        value = mobileNumber,
        onValueChange = { updatedMobileNumber -> onMobileNumberChange(updatedMobileNumber) },
        modifier = modifier,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        label = label,
        placeholder = placeholder,
        leadingIcon = {
            CountryPicker(
                modifier = modifier,
                defaultPaddingValues = defaultPaddingValues,
                selectedCountryProperties = selectedCountryProperties,
                selectedCountryFlagDimensions = selectedCountryFlagDimensions,
                selectedCountryTextStyles = selectedCountryTextStyles,
                countriesListDialogProperties = countriesListDialogProperties,
                countriesListDialogFlagDimensions = countriesListDialogFlagDimensions,
                countriesListDialogTextStyles = countriesListDialogTextStyles,
                defaultCountryCode = defaultCountryCode,
                countriesList = countriesList,
                onCountrySelected = onCountrySelected
            )
        },
        trailingIcon = trailingIcon,
        prefix = prefix,
        suffix = suffix,
        supportingText = supportingText,
        isError = isError,
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            onDone?.invoke()
        }),
        singleLine = singleLine,
        maxLines = maxLines,
        minLines = minLines,
        interactionSource = interactionSource,
        shape = shape,
        colors = colors,
        borderThickness = borderThickness
    )
}