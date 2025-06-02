package com.arpitkatiyarprojects.countrypickerproject.ui.previews

import android.content.res.Configuration
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.arpitkatiyarprojects.countrypickerproject.ui.theme.CountryPickerProjectTheme

/** Apply theme and background- / contentColor to the content of every Preview which uses this composable */
@Composable
fun MyPreview(
    content: @Composable () -> Unit,
) {
    CountryPickerProjectTheme {
        Surface {
            content()
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MyPreviewPreview() {
    MyPreview {
        Text("Hello world!")
    }
}
