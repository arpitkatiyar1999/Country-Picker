# Jetpack Compose Country Code Picker

Jetpack Compose Country Code Picker is a simple, lightweight library built for Android using Jetpack
Compose, designed to provide an easy-to-use country code selection functionality within your Android
app. It seamlessly integrates with Material 3 design principles, offering a modern and consistent
user experience.

![Platform](https://img.shields.io/badge/Platform-Android-green) &nbsp;
![API Level](https://img.shields.io/badge/API-21%2B-skyblue) &nbsp;
![License](https://img.shields.io/badge/License-Apache%202-blue) &nbsp;
![JitPack](https://img.shields.io/badge/JitPack-1.0.0-mediumseagreen) &nbsp;
![Language](https://img.shields.io/badge/Language-Kotlin-orange)

## Requirement

Jetpack Compose Country Code Picker requires Material 3 version 1.2.1 or later to work properly. To
ensure compatibility, please make sure your project includes Material 3 version 1.2.1 or later.

If you are using the Compose BOM to manage compose dependencies, you can check your current Material
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







