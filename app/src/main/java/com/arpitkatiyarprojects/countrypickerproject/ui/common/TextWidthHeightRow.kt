package com.arpitkatiyarprojects.countrypickerproject.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextWidthHeightRow(
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