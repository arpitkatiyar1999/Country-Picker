# Jetpack Compose Country Code Picker

Jetpack Compose Country Code Picker is a simple, lightweight library built for Android using Jetpack
Compose, designed to provide an easy-to-use country code selection functionality within your Android
app. It seamlessly integrates with Material 3 design principles, offering a modern and consistent
user experience. It effortlessly adapts to your application's theme, facilitating seamless integration with the visual identity of your application.


![Platform](https://img.shields.io/badge/Platform-Android-crimson) &nbsp;
![API Level](https://img.shields.io/badge/API-21%2B-yellow) &nbsp;
![License](https://img.shields.io/badge/License-Apache%202-blue) &nbsp;
![JitPack](https://img.shields.io/badge/JitPack-1.0.0-mediumseagreen) &nbsp;
![Language](https://img.shields.io/badge/Language-Kotlin-orange)

## Requirement

Jetpack Compose Country Code Picker requires Material 3 version 1.2.1 or later to work properly. To
ensure compatibility, please make sure your project includes Material 3 version 1.2.1 or later.

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

2. **CountryPickerOutlinedTextField**: This function displays the country picker with  outlined text field.

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









