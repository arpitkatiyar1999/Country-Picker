package com.arpitkatiyarprojects.countrypickerproject.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TextSwitchRow(text: String, isSwitchEnabled: Boolean, onSwitchStateChanged: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = text, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Switch(checked = isSwitchEnabled,
            onCheckedChange = {
                onSwitchStateChanged(it)
            })

    }
}