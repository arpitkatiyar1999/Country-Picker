package com.arpitkatiyarprojects.countrypickerproject.ui.common

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arpitkatiyarprojects.countrypicker.models.CountryDetails
import com.arpitkatiyarprojects.countrypickerproject.R

@Composable
fun CountryDetailsSectionRow(
    selectedCountryDetails: CountryDetails?,
    modifier: Modifier = Modifier
) {
    var isCountryDetailsSectionOpened by remember {
        mutableStateOf(true)
    }
    Row(modifier = modifier
        .fillMaxWidth()
        .clickable {
            isCountryDetailsSectionOpened = !isCountryDetailsSectionOpened
        }
        .padding(horizontal = 16.dp, vertical = 6.dp)
        .animateContentSize()) {
        with(selectedCountryDetails) {
            if (isCountryDetailsSectionOpened) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(SpanStyle(color = Color.Black, fontWeight = FontWeight.Medium)) {
                            append("Country Name:- ")
                        }
                        append(this@with?.countryName ?: "N/A")
                        append("\n")
                        withStyle(SpanStyle(color = Color.Black, fontWeight = FontWeight.Medium)) {
                            append("Country Code:- ")
                        }
                        append(this@with?.countryCode ?: "N/A")
                        append("\n")
                        withStyle(SpanStyle(color = Color.Black, fontWeight = FontWeight.Medium)) {
                            append("Country Phone Code:- ")
                        }
                        append(this@with?.countryPhoneNumberCode ?: "N/A")
                    },
                    fontSize = 14.sp,
                    modifier = Modifier.weight(1f)
                )
            } else {
                Text(
                    text = "${this?.countryName ?: "N/A"}, ${this?.countryCode ?: "N/A"}",
                    modifier = Modifier.weight(1f),
                    fontSize = 14.sp,
                    color = Color.Black,
                )
            }
        }
        Icon(
            painter = painterResource(id = if (isCountryDetailsSectionOpened) R.drawable.ic_drop_up else R.drawable.ic_drop_down),
            contentDescription = null
        )
    }
}