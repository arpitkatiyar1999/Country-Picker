package com.arpitkatiyarprojects.countrypickerproject.ui.country_picker_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arpitkatiyarprojects.countrypickerproject.ui.theme.CountryPickerProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountryPickerProjectTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = MainScreenDestination) {
                    composable<MainScreenDestination> {
                        MainScreen({
                            navController.navigate(CountryPickerWithoutTextFieldDestination)
                        }) {
                            navController.navigate(CountryPickerWithOutlinedTextFieldDestination)
                        }
                    }
                    composable<CountryPickerWithoutTextFieldDestination> {
                        CountryPickerWithoutTextField()
                    }
                    composable<CountryPickerWithOutlinedTextFieldDestination> {
                        CountryPickerWithOutlinedText()
                    }
                }
            }
        }
    }
}