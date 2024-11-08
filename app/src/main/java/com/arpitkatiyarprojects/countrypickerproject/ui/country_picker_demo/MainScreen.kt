package com.arpitkatiyarprojects.countrypickerproject.ui.country_picker_demo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.arpitkatiyarprojects.countrypickerproject.ui.common.SpacerHeight16


@Composable
fun MainScreen(
    onNavigateToCountryPickerWithoutTextField: () -> Unit,
    onNavigateToCountryPickerWithTextField: () -> Unit
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Button(
                onClick = onNavigateToCountryPickerWithoutTextField,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Go To Country Picker Without Text Field")
            }
            SpacerHeight16()
            Button(
                onClick = onNavigateToCountryPickerWithTextField,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Go To Country Picker With Outlined Text Field",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}