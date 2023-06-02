package com.meg4cyberc4t.rubleexchangecourse.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.viewModelFactory
import com.meg4cyberc4t.rubleexchangecourse.data.ValutesResponse
import com.meg4cyberc4t.rubleexchangecourse.domain.MainPageViewModel
import com.meg4cyberc4t.rubleexchangecourse.domain.cbrRequests
import kotlinx.coroutines.flow.asStateFlow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val viewModel: MainPageViewModel = MainPageViewModel();
                    GreetingView(viewModel)
                }
            }
        }
    }
}

@Composable
fun GreetingView(
    viewModel: MainPageViewModel
) {
    val response: String? by viewModel.dataState.collectAsState();
    Text(text = "$response")
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        val viewModel: MainPageViewModel = MainPageViewModel();
        GreetingView(viewModel)
    }
}
