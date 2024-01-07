package com.buranchikov.sevenwindsstudiotest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val token = MutableLiveData<String>()
}