package com.arpitkatiyarprojects.countrypickerproject.ui.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.arpitkatiyarprojects.countrypicker.models.CountryDetails

@Composable
fun CountryDetailsSectionRow(
    selectedCountryDetails: CountryDetails?,
    modifier: Modifier = Modifier
) {
    Text(
        text = buildAnnotatedString {
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
        },
        fontSize = 14.sp,
        modifier = modifier
    )
}