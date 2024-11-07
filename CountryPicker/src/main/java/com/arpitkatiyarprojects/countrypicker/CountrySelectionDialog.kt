package com.arpitkatiyarprojects.countrypicker

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.arpitkatiyarprojects.countrypicker.models.CountriesListDialogProperties
import com.arpitkatiyarprojects.countrypicker.models.CountryDetails
import com.arpitkatiyarprojects.countrypicker.models.CountryPickerDialogTextStyles
import com.arpitkatiyarprojects.countrypicker.models.Dimensions
import com.arpitkatiyarprojects.countrypicker.utils.FunctionHelper.searchForCountry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CountrySelectionDialog(
    countriesList: List<CountryDetails>,
    countriesListDialogProperties: CountriesListDialogProperties,
    countriesListDialogFlagDimensions: Dimensions,
    countriesListDialogTextStyles: CountryPickerDialogTextStyles,
    onDismissRequest: () -> Unit,
    onSelected: (item: CountryDetails) -> Unit,
    properties: DialogProperties = DialogProperties(usePlatformDefaultWidth = false)
) {
    var searchValue by remember { mutableStateOf("") }
    var isSearchEnabled by remember { mutableStateOf(false) }
    var filteredCountries by remember { mutableStateOf(countriesList) }
    val coroutineScope = rememberCoroutineScope()
    BasicAlertDialog(
        modifier = Modifier
            .fillMaxSize(),
        onDismissRequest = onDismissRequest,
        properties = properties,
        content = {
            Surface(
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Scaffold(
                    topBar = {
                        val focusRequester = remember { FocusRequester() }
                        LaunchedEffect(isSearchEnabled) {
                            if (isSearchEnabled) {
                                focusRequester.requestFocus()
                            }
                        }
                        CenterAlignedTopAppBar(
                            title = {
                                if (isSearchEnabled) {
                                    TextField(
                                        modifier = Modifier
                                            .focusRequester(focusRequester)
                                            .fillMaxWidth(),
                                        value = searchValue,
                                        onValueChange = { searchStr ->
                                            searchValue = searchStr
                                            coroutineScope.launch(Dispatchers.Default) {
                                                val filteredCountryList =
                                                    countriesList.searchForCountry(searchStr)
                                                withContext(Dispatchers.Main) {
                                                    filteredCountries = filteredCountryList
                                                }
                                            }
                                        },
                                        placeholder = {
                                            Text(
                                                text = stringResource(R.string.search_country),
                                                color = MaterialTheme.colorScheme.onSurface,
                                            )
                                        },
                                        colors = TextFieldDefaults.colors(
                                            disabledContainerColor = Color.Transparent,
                                            focusedContainerColor = Color.Transparent,
                                            unfocusedContainerColor = Color.Transparent,
                                            disabledIndicatorColor = Color.Transparent,
                                            focusedIndicatorColor = Color.Transparent,
                                            unfocusedIndicatorColor = Color.Transparent,
                                        ),
                                        textStyle = MaterialTheme.typography.labelLarge,
                                    )
                                } else {
                                    Text(
                                        modifier = Modifier.offset(y = (-2).dp),
                                        text = stringResource(R.string.select_country),
                                        style = MaterialTheme.typography.titleMedium,
                                        color = MaterialTheme.colorScheme.onSurface,
                                    )
                                }
                            },
                            navigationIcon = {
                                IconButton(onClick = {
                                    onDismissRequest()
                                }) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                                        contentDescription = null,
                                    )
                                }
                            },
                            actions = {
                                IconButton(onClick = {
                                    isSearchEnabled = !isSearchEnabled
                                    if (!isSearchEnabled) {
                                        searchValue = ""
                                    }
                                }) {
                                    Icon(
                                        imageVector = if (isSearchEnabled) Icons.Default.Clear else Icons.Default.Search,
                                        contentDescription = null,
                                    )
                                }
                            },
                        )
                    },
                ) { paddingValues ->
                    LazyColumn(
                        Modifier
                            .padding(paddingValues)
                            .fillMaxSize(),
                    ) {
                        val countriesData =
                            if (searchValue.isEmpty()) {
                                countriesList
                            } else {
                                filteredCountries
                            }
                        if (countriesData.isEmpty()) {
                            item {
                                Text(
                                    text = stringResource(R.string.no_country_found),
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
                                )
                            }
                        } else {
                            items(countriesData, key = { it.countryCode }) { countryItem ->
                                CountriesListItem(
                                    countryItem,
                                    countriesListDialogProperties,
                                    countriesListDialogFlagDimensions,
                                    countriesListDialogTextStyles
                                ) {
                                    onSelected(countryItem)
                                }
                            }
                        }
                    }
                }
            }
        },
    )
}


@Composable
private fun CountriesListItem(
    countryItem: CountryDetails,
    countriesListDialogProperties: CountriesListDialogProperties,
    countriesListDialogFlagDimensions: Dimensions,
    countriesListDialogTextStyles: CountryPickerDialogTextStyles,
    onCountrySelected: () -> Unit
) {
    ListItem(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            onCountrySelected()
        },
        leadingContent = {
            Image(
                modifier = Modifier
                    .width(countriesListDialogFlagDimensions.width)
                    .height(countriesListDialogFlagDimensions.height),
                painter = painterResource(id = countryItem.countryFlag),
                contentDescription = countryItem.countryName,
            )
        },
        headlineContent = {
            Text(text = buildAnnotatedString {
                withStyle(style = countriesListDialogTextStyles.countryNameTextStyle.toSpanStyle()) {
                    append(countryItem.countryName)
                }
                if (countriesListDialogProperties.showCountryCode) {
                    append("  ")
                    append("(")
                    withStyle(style = countriesListDialogTextStyles.countryCodeTextStyle.toSpanStyle()) {
                        append(countryItem.countryCode.uppercase())
                    }
                    append(")")
                }
            })
        },
        trailingContent = {
            Text(
                text = countryItem.countryPhoneNumberCode,
                style = countriesListDialogTextStyles.countryPhoneCodeTextStyle,
            )
        })
}
