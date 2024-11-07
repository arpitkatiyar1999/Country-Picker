package com.arpitkatiyarprojects.countrypickerproject.ui.common

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arpitkatiyarprojects.countrypickerproject.R

@Composable
fun TitleSettingsComposable(
    titleText: String,
    modifier: Modifier = Modifier,
    settings: @Composable () -> Unit
) {
    var whetherShowSettingsSection by remember {
        mutableStateOf(false)
    }
    Column(modifier = modifier.animateContentSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    whetherShowSettingsSection = !whetherShowSettingsSection
                }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = titleText, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Icon(
                painter = painterResource(id = if (whetherShowSettingsSection) R.drawable.ic_drop_up else R.drawable.ic_drop_down),
                contentDescription = null
            )
        }
        if (whetherShowSettingsSection) {
            Box(modifier = Modifier.padding(horizontal = 12.dp, vertical = 16.dp)) {
                settings()
            }
        }
    }
}