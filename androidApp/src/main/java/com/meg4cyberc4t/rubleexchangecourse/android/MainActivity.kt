package com.meg4cyberc4t.rubleexchangecourse.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.runtime.*
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.viewModelFactory
import com.meg4cyberc4t.rubleexchangecourse.data.ValuteItem
import com.meg4cyberc4t.rubleexchangecourse.data.ValutesResponse
import com.meg4cyberc4t.rubleexchangecourse.domain.MainPageViewModel
import com.meg4cyberc4t.rubleexchangecourse.domain.cbrRequests
import kotlinx.coroutines.flow.asStateFlow


val viewModel: MainPageViewModel = MainPageViewModel();

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                MainScreen()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(): Unit {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    val valutesResponse: ValutesResponse? by viewModel.dataState.collectAsState()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                scrollBehavior = scrollBehavior,
                title = {
                    Text(
                        if (valutesResponse == null) "Загрузка" else "Валюты к рублю",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
            )
        },
        content = { innerPadding ->
            if (valutesResponse != null) {
                LazyColumn(contentPadding = innerPadding) {
                    items(valutesResponse!!.valute.values.toList()) { valuteItem ->
                        ValuteTile(item = valuteItem)
                    }
                }
            }
        }
    )
}



