package com.arpitkatiyarprojects.countrypicker

import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.arpitkatiyarprojects.countrypicker.models.BorderThickness

/**
 * Composable function for displaying an outlined text field with picker functionality.
 *
 * @param value The current value of the text field.
 * @param onValueChange Callback triggered when the value of the text field changes.
 * @param modifier [Modifier] for customizing the layout and appearance of the text field.
 * @param enabled Whether the text field is enabled for user interaction.
 * @param readOnly Whether the text field is read-only.
 * @param textStyle The style of the text displayed in the text field.
 * @param label The label to be displayed above the text field.
 * @param placeholder The placeholder text to be displayed when the text field is empty.
 * @param leadingIcon The icon to be displayed at the start of the text field.
 * @param trailingIcon The icon to be displayed at the end of the text field.
 * @param prefix The content to be displayed before the text input.
 * @param suffix The content to be displayed after the text input.
 * @param supportingText The additional supporting text to be displayed below the text field.
 * @param isError Whether the text field is in an error state.
 * @param visualTransformation The visual transformation to be applied to the text.
 * @param keyboardOptions The keyboard options to be applied to the text field.
 * @param keyboardActions The keyboard actions to be applied to the text field.
 * @param singleLine Whether the text field should be limited to a single line.
 * @param maxLines The maximum number of lines allowed in the text field.
 * @param minLines The minimum number of lines allowed in the text field.
 * @param interactionSource The interaction source of the text field.
 * @param shape The shape of the text field.
 * @param colors The colors to be used for the text field.
 * @param borderThickness The thickness of the border for the text field.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PickerOutlinedTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = OutlinedTextFieldDefaults.shape,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(),
    borderThickness: BorderThickness = BorderThickness()
) {
    val textColor = textStyle.color.takeOrElse {
        colors.textColor(enabled, isError, interactionSource).value
    }
    val mergedTextStyle = textStyle.merge(TextStyle(color = textColor))
    CompositionLocalProvider(LocalTextSelectionColors provides colors.textSelectionColors) {
        BasicTextField(
            value = value,
            modifier = if (label != null) {
                modifier
                    // Merge semantics at the beginning of the modifier chain to ensure padding is
                    // considered part of the text field.
                    .semantics(mergeDescendants = true) {}
                    .padding(top = 8.dp)
            } else {
                modifier
            }.defaultMinSize(
                minWidth = OutlinedTextFieldDefaults.MinWidth,
                minHeight = OutlinedTextFieldDefaults.MinHeight
            ),
            onValueChange = onValueChange,
            enabled = enabled,
            readOnly = readOnly,
            textStyle = mergedTextStyle,
            cursorBrush = SolidColor(colors.cursorColor(isError).value),
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            interactionSource = interactionSource,
            singleLine = singleLine,
            maxLines = maxLines,
            minLines = minLines,
            decorationBox = @Composable { innerTextField ->
                OutlinedTextFieldDefaults.DecorationBox(
                    value = value.text,
                    visualTransformation = visualTransformation,
                    innerTextField = innerTextField,
                    placeholder = placeholder,
                    label = label,
                    leadingIcon = leadingIcon,
                    trailingIcon = trailingIcon,
                    prefix = prefix,
                    suffix = suffix,
                    supportingText = supportingText,
                    singleLine = singleLine,
                    enabled = enabled,
                    isError = isError,
                    interactionSource = interactionSource,
                    colors = colors,
                    container = {
                        OutlinedTextFieldDefaults.Container(
                            enabled = enabled,
                            isError = isError,
                            interactionSource = interactionSource,
                            colors = colors,
                            shape = shape,
                            focusedBorderThickness = borderThickness.focusedBorderThickness,
                            unfocusedBorderThickness = borderThickness.unfocusedBorderThickness
                        )
                    }
                )
            }
        )
    }
}

/**
 * Composable function for displaying an outlined text field with picker functionality.
 *
 * @param value The current value of the text field.
 * @param onValueChange Callback triggered when the value of the text field changes.
 * @param modifier [Modifier] for customizing the layout and appearance of the text field.
 * @param enabled Whether the text field is enabled for user interaction.
 * @param readOnly Whether the text field is read-only.
 * @param textStyle The style of the text displayed in the text field.
 * @param label The label to be displayed above the text field.
 * @param placeholder The placeholder text to be displayed when the text field is empty.
 * @param leadingIcon The icon to be displayed at the start of the text field.
 * @param trailingIcon The icon to be displayed at the end of the text field.
 * @param prefix The content to be displayed before the text input.
 * @param suffix The content to be displayed after the text input.
 * @param supportingText The additional supporting text to be displayed below the text field.
 * @param isError Whether the text field is in an error state.
 * @param visualTransformation The visual transformation to be applied to the text.
 * @param keyboardOptions The keyboard options to be applied to the text field.
 * @param keyboardActions The keyboard actions to be applied to the text field.
 * @param singleLine Whether the text field should be limited to a single line.
 * @param maxLines The maximum number of lines allowed in the text field.
 * @param minLines The minimum number of lines allowed in the text field.
 * @param interactionSource The interaction source of the text field.
 * @param shape The shape of the text field.
 * @param colors The colors to be used for the text field.
 * @param borderThickness The thickness of the border for the text field.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PickerOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = OutlinedTextFieldDefaults.shape,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(),
    borderThickness: BorderThickness = BorderThickness()
) {
    val textColor = textStyle.color.takeOrElse {
        colors.textColor(enabled, isError, interactionSource).value
    }
    val mergedTextStyle = textStyle.merge(TextStyle(color = textColor))
    CompositionLocalProvider(LocalTextSelectionColors provides colors.textSelectionColors) {
        BasicTextField(
            value = value,
            modifier = if (label != null) {
                modifier
                    // Merge semantics at the beginning of the modifier chain to ensure padding is
                    // considered part of the text field.
                    .semantics(mergeDescendants = true) {}
                    .padding(top = 8.dp)
            } else {
                modifier
            }.defaultMinSize(
                minWidth = OutlinedTextFieldDefaults.MinWidth,
                minHeight = OutlinedTextFieldDefaults.MinHeight
            ),
            onValueChange = onValueChange,
            enabled = enabled,
            readOnly = readOnly,
            textStyle = mergedTextStyle,
            cursorBrush = SolidColor(colors.cursorColor(isError).value),
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            interactionSource = interactionSource,
            singleLine = singleLine,
            maxLines = maxLines,
            minLines = minLines,
            decorationBox = @Composable { innerTextField ->
                OutlinedTextFieldDefaults.DecorationBox(
                    value = value,
                    visualTransformation = visualTransformation,
                    innerTextField = innerTextField,
                    placeholder = placeholder,
                    label = label,
                    leadingIcon = leadingIcon,
                    trailingIcon = trailingIcon,
                    prefix = prefix,
                    suffix = suffix,
                    supportingText = supportingText,
                    singleLine = singleLine,
                    enabled = enabled,
                    isError = isError,
                    interactionSource = interactionSource,
                    colors = colors,
                    container = {
                        OutlinedTextFieldDefaults.Container(
                            enabled = enabled,
                            isError = isError,
                            interactionSource = interactionSource,
                            colors = colors,
                            shape = shape,
                            focusedBorderThickness = borderThickness.focusedBorderThickness,
                            unfocusedBorderThickness = borderThickness.unfocusedBorderThickness
                        )
                    }
                )
            }
        )
    }
}

/**
 * Composable function that returns the text color state based on the text field's enabled state, error state, and focus interaction.
 *
 * @param enabled A Boolean value indicating whether the text field is enabled. If false, the text color will be set to the disabled color.
 * @param isError A Boolean value indicating whether an error state is present. If true, the text color will be set to the error color.
 * @param interactionSource An [InteractionSource] used to collect focus state. The text color will change based on whether the text field is focused or not.
 * @return A [State] object containing the color for the text, which is determined by the enabled, error, and focus states.
 */
@Composable
internal fun TextFieldColors.textColor(
    enabled: Boolean,
    isError: Boolean,
    interactionSource: InteractionSource
): State<Color> {
    val focused by interactionSource.collectIsFocusedAsState()

    val targetValue = when {
        !enabled -> disabledTextColor
        isError -> errorTextColor
        focused -> focusedTextColor
        else -> unfocusedTextColor
    }
    return rememberUpdatedState(targetValue)
}

/**
 * Composable function that returns the cursor color state based on the error condition.
 *
 * @param isError A Boolean value indicating whether an error is present. If true, the cursor color will be set to the error color.
 * @return A [State] object containing the color for the cursor, either the default color or the error color depending on the [isError] flag.
 */
@Composable
internal fun TextFieldColors.cursorColor(
    isError: Boolean
): State<Color> {
    return rememberUpdatedState(if (isError) errorCursorColor else cursorColor)
}