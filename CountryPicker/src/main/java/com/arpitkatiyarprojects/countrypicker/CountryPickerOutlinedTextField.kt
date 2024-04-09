package com.arpitkatiyarprojects.countrypicker

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.arpitkatiyarprojects.countrypicker.models.BorderThickness
import com.arpitkatiyarprojects.countrypicker.models.CountryDetails
import com.arpitkatiyarprojects.countrypicker.models.CountryPickerProperties
import com.arpitkatiyarprojects.countrypicker.models.Dimensions
import com.arpitkatiyarprojects.countrypicker.models.PickerTextStyles

/**
 * @param mobileNumber The mobile number to be shown in the text field.
 * @param onMobileNumberChange The callback that is triggered when the input service updates the mobile number. An updated mobile number comes as a parameter of the callback.
 * @param onCountrySelected The callback function is triggered each time a country is selected within the picker. Additionally, it is also invoked when the picker is first displayed on the screen with the default selected country.
 * @param modifier The Modifier to be applied to this text field.
 * @param defaultPaddingValues The spacing values to apply internally between the container and the content
 * @param countryPickerProperties Defines the configurations for the CountryPicker
 * @param countryFlagDimensions  Defines the dimensions for the country flags displayed within the picker.
 * @param pickerTextStyles Defines the text styles for the picker items.
 * @param defaultCountryCode Specifies the default country code to be pre-selected in the picker. The code must adhere to the 2-letter ISO standard. For example, "in" represents India. If not explicitly provided, the picker will automatically detect the user's country.
 * @param countriesList specifies a list of countries to populate in the picker. If not provided, the picker will use a predefined list of countries. It's essential that the provided countries list strictly adheres to the standard 2-letter ISO code format for each country.
 * @param enabled controls the enabled state of this text field. When false, this component will not respond to user input, and it will appear visually disabled and disabled to accessibility services.
 * @param readOnly controls the editable state of the text field. When true, the text field cannot be modified. However, a user can focus it and copy text from it. Read-only text fields are usually used to display pre-filled forms that a user cannot edit.
 * @param textStyle the style to be applied to the input text. Defaults to LocalTextStyle.
 * @param label the optional label to be displayed inside the text field container. The default text style for internal Text is Typography.bodySmall when the text field is in focus and Typography.bodyLarge when the text field is not in focus
 * @param placeholder the optional placeholder to be displayed when the text field is in focus and the input text is empty. The default text style for internal Text is Typography.bodyLarge
 * @param trailingIcon the optional trailing icon to be displayed at the end of the text field container
 * @param prefix the optional prefix to be displayed before the input text in the text field
 * @param suffix the optional suffix to be displayed after the input text in the text field
 * @param supportingText The optional supporting text to be displayed below the text field
 * @param isError indicates if the text field's current value is in error. If set to true, the label, bottom indicator and trailing icon by default will be displayed in error color
 * @param visualTransformation transforms the visual representation of the input value For example, you can use PasswordVisualTransformation to create a password text field. By default, no visual transformation is applied.
 * @param singleLine when true, this text field becomes a single horizontally scrolling text field instead of wrapping onto multiple lines. The keyboard will be informed to not show the return key as the ImeAction. Note that maxLines parameter will be ignored as the maxLines attribute will be automatically set to 1.
 * @param maxLines the maximum height in terms of maximum number of visible lines. It is required that 1 <= minLines <= maxLines. This parameter is ignored when singleLine is true.
 * @param minLines the minimum height in terms of minimum number of visible lines. It is required that 1 <= minLines <= maxLines. This parameter is ignored when singleLine is true.
 * @param interactionSource the MutableInteractionSource representing the stream of Interactions for this text field. You can create and pass in your own remembered instance to observe Interactions and customize the appearance / behavior of this text field in different states.
 * @param shape defines the shape of this text field's border
 * @param colors TextFieldColors that will be used to resolve the colors used for this text field in different
 * @param borderThickness Represents the border thickness for focused and unfocused states.
 * @param onDone The callback is triggered when the user clicks the Done button on the keyboard, as the default IME action is set to Done.
 */
@Composable
fun CountryPickerOutlinedTextField(
    mobileNumber: String,
    onMobileNumberChange: (String) -> Unit,
    onCountrySelected: (country: CountryDetails) -> Unit,
    modifier: Modifier = Modifier,
    defaultPaddingValues: PaddingValues = PaddingValues(4.dp, 6.dp),
    countryPickerProperties: CountryPickerProperties = CountryPickerProperties(),
    countryFlagDimensions: Dimensions = Dimensions(28.dp, 18.dp),
    pickerTextStyles: PickerTextStyles = PickerTextStyles(),
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
    shape: Shape = OutlinedTextFieldDefaults.shape,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(),
    borderThickness: BorderThickness = BorderThickness(),
    onDone: () -> Unit = {},
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
                modifier = Modifier
                    .padding(start = 8.dp)
                    .clip(RoundedCornerShape(12.dp)),
                defaultPaddingValues = defaultPaddingValues,
                countryPickerProperties = countryPickerProperties,
                countryFlagDimensions = countryFlagDimensions,
                pickerTextStyles = pickerTextStyles,
                defaultCountryCode = defaultCountryCode,
                countriesList = countriesList,
            ) { selectedCountry ->
                onCountrySelected(selectedCountry)
            }
        },
        trailingIcon = trailingIcon,
        prefix = prefix,
        suffix = suffix,
        supportingText = supportingText,
        isError = isError,
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            onDone()
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