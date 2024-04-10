# Jetpack Compose Country Code Picker

Jetpack Compose Country Code Picker is a simple, lightweight library built for Android using Jetpack
Compose, designed to provide an easy-to-use country code selection functionality within your Android
app. It seamlessly integrates with Material 3 design principles, offering a modern and consistent
user experience. It effortlessly adapts to your application's theme, facilitating seamless
integration with the visual identity of your application.

![Platform](https://img.shields.io/badge/Platform-Android-crimson) &nbsp;
![API Level](https://img.shields.io/badge/API-21%2B-yellow) &nbsp;
![License](https://img.shields.io/badge/License-Apache%202-blue) &nbsp;
[![](https://jitpack.io/v/arpitkatiyar1999/Country-Picker.svg)](https://jitpack.io/#arpitkatiyar1999/Country-Picker) &nbsp;
![Language](https://img.shields.io/badge/Language-Kotlin-orange)

## Preview


|  <div style="width:50%;">CountryPicker</div>                                                                          | <div style="width:50%;">CountryPickerOutlinedTextField</div>   |
|:---------------------------------------------------------------------------------------------------------------------:|:------------------------------:|
| <video src="https://github.com/arpitkatiyar1999/Country-Picker/assets/60139160/6ae5d601-f53e-480b-a00d-74aa8095860b"> | <video src="https://github.com/arpitkatiyar1999/Country-Picker/assets/60139160/97f3186f-f86c-49fc-a73c-b38562a43eb1">        |                                                                                            |

## Requirement


Jetpack Compose Country Code Picker requires Material 3 version **1.2.1** or later to work properly.
To
ensure compatibility, please make sure your project includes Material 3 version **1.2.1** or later.

If you are using the Compose BOM to manage dependencies, you can check your current Material
3 version by referring to
the [Compose BOM mapping](https://developer.android.com/develop/ui/compose/bom/bom-mapping).

## Installation

### Step 1: Add the JitPack repository to your build file

Add it in your `settings.gradle` file at the end of repositories:

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}
```

### Step 2: Add the dependency

Add it in your `build.gradle` (module level) file:

```kotlin
dependencies {
    implementation("com.github.arpitkatiyar1999:Country-Picker:<latest-version>")
    implementation("androidx.compose.material3:material3:1.2.1")
}
```

## Usage

This library provides two composable functions for country code selection:

1. **CountryPicker**: This function displays the country picker without any outlined text field.

```kotlin
@Composable
fun CountryPicker(
    modifier: Modifier = Modifier,
    defaultPaddingValues: PaddingValues = PaddingValues(4.dp, 6.dp),
    countryPickerProperties: CountryPickerProperties = CountryPickerProperties(),
    countryFlagDimensions: Dimensions = Dimensions(28.dp, 18.dp),
    pickerTextStyles: PickerTextStyles = PickerTextStyles(),
    defaultCountryCode: String? = null,
    countriesList: List<String>? = null,
    onCountrySelected: (country: CountryDetails) -> Unit
)
```

- `defaultPaddingValues`: PaddingValues -The spacing values to apply internally between the
  container and the content.


- `countryPickerProperties`: CountryPickerProperties - Defines the configurations for the
  CountryPicker. The configurations include:-

    - `showCountryFlag`: Boolean - Specifies whether to display the country flag within the picker.
    - `showCountryPhoneCode`: Boolean - Specifies whether to display the country phone code within
      the picker.
    - `showCountryName`: Boolean - Specifies whether to display the country name within the picker.
    - `showCountryCode`: Boolean - Specifies whether to display the country code within the picker.
    - `spaceAfterCountryFlag`: Dp - Defines the spacing after the country flag,
      only if `showCountryFlag = true`.
    - `spaceAfterCountryPhoneCode`: Dp - Defines the spacing after the country phone code,
      only if `showCountryPhoneCode = true`.
    - `spaceAfterCountryName`: Dp - Defines the spacing after the country name,
      only if `showCountryName = true`.
    - `spaceAfterCountryCode`: Dp - Defines the spacing after the country code,
      only if `showCountryCode = true`.


- `countryFlagDimensions`: Dimensions - Defines the dimensions for the country flags displayed
  within the picker.


- `pickerTextStyles`: PickerTextStyles - Defines the text styles for the picker items. It includes
  text styles for:-

    - `countryPhoneCodeTextStyle`: TextStyle - Specifies the text style for the country phone code.
    - `countryNameTextStyle`: TextStyle - Specifies the text style for the country name.
    - `countryCodeTextStyle`: TextStyle - Specifies the text style for the country code.


- `defaultCountryCode`: String? - Specifies the default country code to be pre-selected in the
  picker. The code must adhere to the 2-letter ISO standard. For example, "in" represents India. If
  not explicitly provided, the picker will automatically detect the user's country.To know
  countries' 2-letter ISO codes, you can refer to
  the [ISO 3166-1 alpha-2 country codes Wikipedia page](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2).


- `countriesList`: List<String>? - Specifies a list of countries to populate in the picker. If not
  provided, the picker will use a predefined list of countries. It's essential that the provided
  countries list strictly adheres to the standard 2-letter ISO code format for each country.


- `onCountrySelected`: (country: CountryDetails) -> Unit - The callback function is triggered each
  time a country is selected within the picker. Additionally, it is also invoked when the picker is
  first displayed on the screen with the default selected country

2. **CountryPickerOutlinedTextField**: This function displays the country picker with outlined text
   field.

```kotlin
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
)
```

- `mobileNumber`: String - The mobile number to be shown in the text field.


- `onMobileNumberChange`: (String) -> Unit - The callback that is triggered when the input service
  updates the mobile number. An updated mobile number comes as a parameter of the callback.


- `borderThickness`: BorderThickness - Represents the border thickness for focused and unfocused
  states.It includes following properties :-

    - `focusedBorderThickness`: Dp - The thickness of the border when focused.
    - `unfocusedBorderThickness`: Dp - The thickness of the border when unfocused.


- `onDone`: () -> Unit - The callback is triggered when the user clicks the `Done` button on the
  keyboard, as the default IME action is set to `Done`.

##### This library also provides a function to test whether the provided number is valid or not. To use this function, use the following:

```kotlin
CountryPickerUtils.isMobileNumberValid(mobileNumber: String)
```

Where mobileNumber must be in the format of country phone code followed by the mobile number. For
example, for India, use +919999999999.









