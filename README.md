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
| <video src="https://github.com/user-attachments/assets/2eee0727-257d-4e04-95c5-b1fad292de93"> | <video src="https://github.com/user-attachments/assets/b53c7717-44ea-462f-99b1-06789cf0a865">        |                                                                                            |

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
}
```

## Overview

This library provides two composable functions for country code selection:

1. **CountryPicker**: This function displays the country picker without any text field.

```kotlin
@Composable
fun CountryPicker(
  modifier: Modifier = Modifier,
  defaultPaddingValues: PaddingValues = PaddingValues(4.dp, 6.dp),
  selectedCountryDisplayProperties: SelectedCountryDisplayProperties = SelectedCountryDisplayProperties(),
  countriesListDialogDisplayProperties: CountriesListDialogDisplayProperties = CountriesListDialogDisplayProperties(),
  defaultCountryCode: String? = null,
  countriesList: List<String>? = null,
  onCountrySelected: (country: CountryDetails) -> Unit
)
```

##### Parameters

- `defaultPaddingValues: PaddingValues`   Specifies padding within the picker container, providing spacing between the  container and its content.

- `selectedCountryDisplayProperties: SelectedCountryDisplayProperties`: Configures display properties for the selected country in the picker. The properties include:-

  - `properties: SelectedCountryProperties`: Defines the visibility and spacing options for different country details. It has following options:-
    - `showCountryFlag: Boolean` - Determines if the country flag is displayed. Default is `true`.
    - `showCountryPhoneCode: Boolean` - Determines if the country phone code is displayed. Default is `true`.
    - `showCountryName: Boolean` - Determines if the country name is displayed. Default is `false`.
    - `showCountryCode: Boolean` - Determines if the country code (e.g., "IN") is displayed. Default is `false`.
    - `spaceAfterCountryFlag: Dp` - Specifies spacing after the country flag. Default is `8.dp`.
    - `spaceAfterCountryPhoneCode: Dp` - Specifies spacing after the country phone code. Default is `6.dp`.
    - `spaceAfterCountryName: Dp` - Specifies spacing after the country name. Default is `6.dp`.
    - `spaceAfterCountryCode: Dp` - Specifies spacing after the country code. Default is `6.dp`.

  - `flagDimensions: FlagDimensions`: Sets the dimensions for the selected country flag, including the following:-
    - `width: Dp` - Width of the flag. Default is `28.dp`.
    - `height: Dp` - Height of the flag. Default is `18.dp`.

  - `textStyles: SelectedCountryTextStyles`: Defines text styles for displaying selected country details, including the following:-
    - `countryPhoneCodeTextStyle: TextStyle` - Style for the country phone code text. Default is `Bold`.
    - `countryNameTextStyle: TextStyle` - Style for the country name text. Default is `TextStyle()`.
    - `countryCodeTextStyle: TextStyle` - Style for the country code text. Default is `TextStyle()`.


- `countriesListDialogDisplayProperties: CountriesListDialogDisplayProperties`-  Configures the display properties for the country selection dialog. The properties include:-

  - `properties: CountriesListDialogProperties`: Configures visibility options for the country code in the dialog list. It has following options:-
    - `showCountryCode: Boolean` - Specifies if the country code (e.g., "IN") should be shown in the dialog list. Default is `false`.

  - `flagDimensions: FlagDimensions`: Sets the dimensions for flags displayed in the dialog, including the following:
    - `width: Dp` - Width of the flag. Default is `30.dp`.
    - `height: Dp` - Height of the flag. Default is `20.dp`.

  - `textStyles: CountryPickerDialogTextStyles`: Sets text style settings for country list dialog, including the following:-
    - `countryPhoneCodeTextStyle: TextStyle?` - Style for displaying the country phone code in the list. Default is `null`.
    - `countryNameTextStyle: TextStyle?` - Style for displaying the country name in the list. Default is `null`.
    - `countryCodeTextStyle: TextStyle?` - Style for displaying the country code in the list. Default is `null`.

- `defaultCountryCode`: `String?`-   Specifies the default country code to be pre-selected in the
  picker. The code must adhere to the 2-letter ISO standard. For example, "in" represents India. If
  not explicitly provided, the picker will automatically detect the user's country.To know
  countries' 2-letter ISO codes, you can refer to
  the [ISO 3166-1 alpha-2 country codes Wikipedia page](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2).

- `countriesList: List<String>?`-  Specifies a list of countries to populate in the picker. If not provided, the picker will use a predefined list of countries. It's essential that the provided countries list strictly adheres to the standard 2-letter ISO code format for each country.

- `onCountrySelected: (country: CountryDetails) -> Unit`- The callback function is triggered each time a country is selected within the picker. Additionally, it is also invoked when the picker is first displayed on the screen with the default selected country.


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
  selectedCountryDisplayProperties: SelectedCountryDisplayProperties = SelectedCountryDisplayProperties(),
  countriesListDialogDisplayProperties: CountriesListDialogDisplayProperties = CountriesListDialogDisplayProperties(),
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
)
```
##### Parameters

- `mobileNumber: String` - The mobile number to be shown in the text field.


- `onMobileNumberChange: (String) -> Unit` - The callback that is triggered when the input service
  updates the mobile number. An updated mobile number comes as a parameter of the callback.


- `borderThickness: BorderThickness` - Represents the border thickness for focused and unfocused
  states.It has following properties :-

  - `focusedBorderThickness: Dp` - The thickness of the border when focused.
  - `unfocusedBorderThickness: Dp` - The thickness of the border when unfocused.


- `onDone: () -> Unit` - The callback is triggered when the user clicks the `Done` button on the
  keyboard, as the default IME action is set to `Done`.

### Helper Functions


| **Function**                                      | **Description**                                                                                     | **Parameters**                                                                                  |
|--------------------------------------------------------|-----------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|
| `isMobileNumberValid(mobileNumber: String, countryCode: String) : Boolean` | Validates a mobile number based on the provided country code.                                          | `mobileNumber` : The mobile number to validate, which should not include the country’s phone code at the beginning.<br> `countryCode` : The country code for validating the mobile number. |
| `getExampleMobileNumber(countryCode: String, formatNumber: Boolean = false): String` | Retrieves an example mobile number for a given country code, optionally formatted.                   | `countryCode` : The country code for which the example mobile number is to be generated.<br> `formatNumber` : A boolean value (default is `false`). If `true`, the number will be formatted, otherwise, it will be raw. |
| `getFormattedMobileNumber(mobileNumber: String, countryCode: String): String` | Formats a mobile number according to the country’s specific mobile number format, based on the provided country code. This function should only be invoked after ensuring that the mobile number is valid.. | `mobileNumber` : The raw mobile number that needs to be formatted. <br> `countryCode` : The country code that defines the formatting rules for the mobile number. |

---

> **Note**:  For all the above functions, the country code must follow the 2-letter ISO standard (e.g., "IN" for India). For a full list of country codes, please refer to the [ISO 3166-1 alpha-2 country codes Wikipedia page](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2).


## Example Usage

```kotlin
// Example for isMobileNumberValid
val isValid = CountryPickerUtils.isMobileNumberValid("8123456789", "IN")
println(isValid) // Output: true

// Example for getExampleMobileNumber
val exampleNumber = CountryPickerUtils.getExampleMobileNumber("IN")
println(exampleNumber) // Output: Example formatted number, like "81234 56789"

// Example for getFormattedMobileNumber
val formattedNumber = CountryPickerUtils.getFormattedMobileNumber("8123456789", "IN")
println(formattedNumber) // Output: Formatted number, like "81234 56789"
```

For detailed examples of implementing `CountryPicker` and `CountryPickerOutlinedTextField`:

- **CountryPicker**: Refer to the [CountryPicker example code](https://github.com/arpitkatiyar1999/Country-Picker/blob/2.0.0/app/src/main/java/com/arpitkatiyarprojects/countrypickerproject/ui/country_picker_demo/CountryPickerWithoutTextField.kt) to explore configuration options and usage examples for general country selection.

- **CountryPickerOutlinedTextField**: Check out the [CountryPickerOutlinedTextField example code](https://github.com/arpitkatiyar1999/Country-Picker/blob/2.0.0/app/src/main/java/com/arpitkatiyarprojects/countrypickerproject/ui/country_picker_demo/CountryPickerWithOutlinedTextField.kt) for a practical implementation of country selection within an outlined text field, showcasing display options and customizations.

## Versioning Format

This library follows the `Major.Minor.Patch` versioning format:

- **Major**: Introduces new features, removes deprecated code, and may modify function signatures for improved readability and performance. Major version updates may include breaking changes.

- **Minor**: Adds new features and may deprecate outdated code, while retaining compatibility within the current major version.

- **Patch**: Provides bug fixes and minor improvements that do not affect the public API or introduce new features.

> **Note**: When updating the library, be cautious with major version updates, as they may introduce breaking changes and could be incompatible with previous versions.

## Contributing

We welcome contributions to this project! Please follow these steps to get started:

1. **Fork the Repository**: Click on the "Fork" button at the top of the repository page to create a copy under your GitHub account.

2. **Clone the Repository**: Clone your forked repository to your local machine to start working on your changes.

3. **Create a New Branch**: To keep your work organized, create a new branch for each contribution.

4. **Make Your Changes**: Implement your changes and ensure they are tested and documented as needed.

5. **Commit and Push**: Write clear and descriptive commit messages, then push your branch to your fork.

6. **Submit a Pull Request**: Open a pull request (PR) from your branch in the forked repository to the `master` branch of the original repository. Include a clear description of your changes and reference any relevant issues.

Thank you for contributing!









