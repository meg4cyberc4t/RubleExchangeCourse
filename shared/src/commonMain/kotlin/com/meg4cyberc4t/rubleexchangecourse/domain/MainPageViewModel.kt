package com.meg4cyberc4t.rubleexchangecourse.domain

import com.meg4cyberc4t.rubleexchangecourse.data.ValutesResponse
import dev.icerock.moko.mvvm.livedata.MutableLiveData
import kotlinx.coroutines.GlobalScope
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainPageViewModel : ViewModel(){
    var dataState = MutableStateFlow<String?>(null)

    init {
        viewModelScope.launch{
            loadingData()
        }
    }

    @Throws(Throwable::class)
    private suspend fun loadingData() {
        val res = cbrRequests.getDailyRequest()
        dataState.value = res
    }
}