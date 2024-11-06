package com.arpitkatiyarprojects.countrypickerproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arpitkatiyarprojects.countrypicker.CountryPicker
import com.arpitkatiyarprojects.countrypicker.CountryPickerOutlinedTextField
import com.arpitkatiyarprojects.countrypicker.models.BorderThickness
import com.arpitkatiyarprojects.countrypicker.models.CountriesListDialogProperties
import com.arpitkatiyarprojects.countrypicker.models.CountryDetails
import com.arpitkatiyarprojects.countrypicker.models.Dimensions
import com.arpitkatiyarprojects.countrypicker.models.SelectedCountryProperties
import com.arpitkatiyarprojects.countrypicker.utils.CountryPickerUtils
import com.arpitkatiyarprojects.countrypickerproject.ui.theme.CountryPickerProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountryPickerProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CountryPickerWithoutOutlinedText()
                        //CountryPickerWithOutlinedText()
                    }
                }
            }
        }
    }
}


@Composable
fun CountryPickerWithoutOutlinedText() {
    val showSelectedCountryFlagState = remember {
        mutableStateOf(true)
    }
    val showSelectedCountryPhoneCodeState = remember {
        mutableStateOf(true)
    }
    val showSelectedCountryNameState = remember {
        mutableStateOf(false)
    }
    val showSelectedCountryCodeState = remember {
        mutableStateOf(false)
    }
    val spaceAfterSelectedCountryFlagMutableState = remember {
        mutableStateOf(8.dp)
    }
    val spaceAfterSelectedCountryPhoneCode = remember {
        mutableStateOf(6.dp)
    }
    val spaceAfterSelectedCountryName = remember {
        mutableStateOf(6.dp)
    }
    val spaceAfterSelectedCountryCode = remember {
        mutableStateOf(6.dp)
    }

    val selectedCountryFlagWidthState = remember {
        mutableStateOf(28.dp)
    }
    val selectedCountryFlagHeightState = remember {
        mutableStateOf(18.dp)
    }
    val selectedCountryState: MutableState<CountryDetails?> = remember {
        mutableStateOf(null)
    }

    val countryListFlagWidthState = remember {
        mutableStateOf(30.dp)
    }
    val countryListFlagHeightState = remember {
        mutableStateOf(20.dp)
    }
    val countryListShowCountryCode = remember {
        mutableStateOf(false)
    }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        CountryPicker(
            modifier = Modifier.fillMaxWidth(),
            selectedCountryProperties = SelectedCountryProperties(
                showSelectedCountryFlagState.value,
                showSelectedCountryPhoneCodeState.value,
                showSelectedCountryNameState.value,
                showSelectedCountryCodeState.value,
                spaceAfterSelectedCountryFlagMutableState.value,
                spaceAfterSelectedCountryPhoneCode.value,
                spaceAfterSelectedCountryName.value,
                spaceAfterSelectedCountryCode.value
            ),
            selectedCountryFlagDimensions = Dimensions(
                selectedCountryFlagWidthState.value,
                selectedCountryFlagHeightState.value
            ),
            countriesListDialogProperties = CountriesListDialogProperties(countryListShowCountryCode.value),
            countriesListDialogFlagDimensions = Dimensions(
                countryListFlagWidthState.value,
                countryListFlagHeightState.value
            )
        ) {
            selectedCountryState.value = it
        }
        SpacerHeight16()
        CountryDetailsSectionRow(selectedCountryState.value)
        SpacerHeight16()
        Text(text = "Selected Country Settings:- ", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Column(modifier = Modifier.padding(horizontal = 12.dp, vertical = 16.dp)) {
            TextWidthHeightRow(selectedCountryFlagWidthState, selectedCountryFlagHeightState)
            SpacerHeight4()
            TextSwitchRow(text = "Show Country Flag", showSelectedCountryFlagState)
            SpacerHeight4()
            TextSwitchRow(text = "Show Country Phone Code", showSelectedCountryPhoneCodeState)
            SpacerHeight4()
            TextSwitchRow(text = "Show Country Name", showSelectedCountryNameState)
            SpacerHeight4()
            TextSwitchRow(text = "Show Country Code", showSelectedCountryCodeState)
            SpacerHeight4()
            TextProgressRow(
                text = "Space After Country Flag",
                valueChangeMutableState = spaceAfterSelectedCountryFlagMutableState
            )
            SpacerHeight4()
            TextProgressRow(
                text = "Space After Country Phone Code",
                valueChangeMutableState = spaceAfterSelectedCountryPhoneCode
            )
            SpacerHeight4()
            TextProgressRow(
                text = "Space After Country Name",
                valueChangeMutableState = spaceAfterSelectedCountryName
            )
            SpacerHeight4()
            TextProgressRow(
                text = "Space After Country Code",
                valueChangeMutableState = spaceAfterSelectedCountryCode
            )
        }
        Text(
            text = "Countries List Dialog Settings:- ",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Column(modifier = Modifier.padding(horizontal = 12.dp, vertical = 16.dp)) {
            TextWidthHeightRow(countryListFlagWidthState, countryListFlagHeightState)
            SpacerHeight4()
            TextSwitchRow(text = "Show Country Code", countryListShowCountryCode)
        }
    }
}


@Composable
fun CountryPickerWithOutlinedText() {
    val showCountryFlagState = remember {
        mutableStateOf(true)
    }
    val showCountryPhoneCodeState = remember {
        mutableStateOf(true)
    }
    val showCountryNameState = remember {
        mutableStateOf(false)
    }
    val showCountryCodeState = remember {
        mutableStateOf(false)
    }
    val spaceAfterCountryFlagMutableState = remember {
        mutableStateOf(8.dp)
    }
    val spaceAfterCountryPhoneCode = remember {
        mutableStateOf(6.dp)
    }
    val spaceAfterCountryName = remember {
        mutableStateOf(6.dp)
    }
    val spaceAfterCountryCode = remember {
        mutableStateOf(6.dp)
    }

    val flagWidthState = remember {
        mutableStateOf(28.dp)
    }
    val flagHeightState = remember {
        mutableStateOf(18.dp)
    }
    val selectedCountryState: MutableState<CountryDetails?> = remember {
        mutableStateOf(null)
    }
    var mobileNumber by remember {
        mutableStateOf("")
    }
    val unfocusedBorderThickness = remember {
        mutableStateOf(2.dp)
    }

    val focusedBorderThickness = remember {
        mutableStateOf(1.dp)
    }

    var isMobileNumberValidationError by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        CountryPickerOutlinedTextField(
            isError = isMobileNumberValidationError,
            supportingText = {
                if (isMobileNumberValidationError) {
                    Text(text = "Invalid mobile number")
                }
            },
            modifier = Modifier.fillMaxWidth(),
            mobileNumber = CountryPickerUtils.getFormattedMobileNumber(
                selectedCountryState.value?.countryCode ?: "IN", mobileNumber
            ),
            onMobileNumberChange = {
                mobileNumber = it
                isMobileNumberValidationError = !CountryPickerUtils.isMobileNumberValid(
                    mobileNumber,
                    selectedCountryState.value?.countryCode ?: "IN"
                )
            },
            placeholder = {
                Text(
                    text = CountryPickerUtils.getExampleMobileNumber(
                        selectedCountryState.value?.countryCode ?: "IN"
                    )
                )
            },
            onCountrySelected = {
                selectedCountryState.value = it
            },
            selectedCountryProperties = SelectedCountryProperties(
                showCountryFlagState.value,
                showCountryPhoneCodeState.value,
                showCountryNameState.value,
                showCountryCodeState.value,
                spaceAfterCountryFlagMutableState.value,
                spaceAfterCountryPhoneCode.value,
                spaceAfterCountryName.value,
                spaceAfterCountryCode.value
            ),
            //countryFlagDimensions = Dimensions(flagWidthState.value, flagHeightState.value),
            borderThickness = BorderThickness(
                focusedBorderThickness.value,
                unfocusedBorderThickness.value
            )
        )
        SpacerHeight16()
        CountryDetailsSectionRow(selectedCountryState.value)
        SpacerHeight16()
        TextWidthHeightRow(flagWidthState, flagHeightState)
        SpacerHeight4()
        TextSwitchRow(text = "Show Country Flag", showCountryFlagState)
        SpacerHeight4()
        TextSwitchRow(text = "Show Country Phone Code", showCountryPhoneCodeState)
        SpacerHeight4()
        TextSwitchRow(text = "Show Country Name", showCountryNameState)
        SpacerHeight4()
        TextSwitchRow(text = "Show Country Code", showCountryCodeState)
        SpacerHeight4()
        TextProgressRow(
            text = "Space After Country Flag",
            valueChangeMutableState = spaceAfterCountryFlagMutableState
        )
        SpacerHeight4()
        TextProgressRow(
            text = "Space After Country Phone Code",
            valueChangeMutableState = spaceAfterCountryPhoneCode
        )
        SpacerHeight4()
        TextProgressRow(
            text = "Space After Country Name",
            valueChangeMutableState = spaceAfterCountryName
        )
        SpacerHeight4()
        TextProgressRow(
            text = "Space After Country Code",
            valueChangeMutableState = spaceAfterCountryCode
        )
        SpacerHeight4()
        TextProgressRow(
            text = "Unfocused Border Thickness",
            valueChangeMutableState = unfocusedBorderThickness
        )
        SpacerHeight4()
        TextProgressRow(
            text = "Focused Border Thickness",
            valueChangeMutableState = focusedBorderThickness
        )

    }
}

@Composable
private fun CountryDetailsSectionRow(selectedCountryDetails: CountryDetails?) {
    Text(text = buildAnnotatedString {
        withStyle(SpanStyle(color = Color.Black, fontWeight = FontWeight.Medium)) {
            append("Country Name:- ")
        }
        append(selectedCountryDetails?.countryName)
        append("\n")
        withStyle(SpanStyle(color = Color.Black, fontWeight = FontWeight.Medium)) {
            append("Country Code:- ")
        }
        append(selectedCountryDetails?.countryCode)
        append("\n")
        withStyle(SpanStyle(color = Color.Black, fontWeight = FontWeight.Medium)) {
            append("Country Phone Code:- ")
        }
        append(selectedCountryDetails?.countryPhoneNumberCode)
    }, fontSize = 14.sp)
}

@Composable
fun SpacerHeight16() {
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun SpacerHeight4() {
    Spacer(modifier = Modifier.height(4.dp))
}

@Composable
fun SpacerWidth4() {
    Spacer(modifier = Modifier.width(4.dp))
}


@Composable
private fun TextWidthHeightRow(
    widthMutableState: MutableState<Dp>,
    heightMutableState: MutableState<Dp>
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Flag Dimensions", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        SpacerWidth4()
        Row(verticalAlignment = Alignment.CenterVertically) {
            BasicTextField(
                textStyle = TextStyle(textAlign = TextAlign.Center),
                value = widthMutableState.value.value.toInt().toString(),
                onValueChange = {
                    widthMutableState.value = it.toIntOrNull()?.dp ?: 0.dp
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.LightGray)
                    .padding(12.dp)
                    .width(20.dp)
            )
            Text(
                text = "×",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            BasicTextField(
                textStyle = TextStyle(textAlign = TextAlign.Center),
                value = heightMutableState.value.value.toInt().toString(), onValueChange = {
                    heightMutableState.value = it.toIntOrNull()?.dp ?: 0.dp
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.LightGray)
                    .padding(12.dp)
                    .width(20.dp)
            )
        }

    }
}

@Composable
private fun TextProgressRow(text: String, valueChangeMutableState: MutableState<Dp>) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = text, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Slider(value = valueChangeMutableState.value.value, onValueChange = {
            valueChangeMutableState.value = it.dp

        }, valueRange = 1f..100f, modifier = Modifier.width(70.dp))
    }
}

@Composable
private fun TextSwitchRow(text: String, switchChangeState: MutableState<Boolean>) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = text, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Switch(checked = switchChangeState.value, onCheckedChange = {
            switchChangeState.value = it
        })

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CountryPickerProjectTheme {
        Greeting("Android")
    }
}