package com.buranchikov.sevenwindsstudiotest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buranchikov.sevenwindsstudiotest.data_classes.CoffeeMenu
import com.buranchikov.sevenwindsstudiotest.data_classes.Location
import com.buranchikov.sevenwindsstudiotest.data_classes.Point

class MainViewModel : ViewModel() {
    val token = MutableLiveData<String>()
    val location = MutableLiveData<List<Location>>()
    val menu = MutableLiveData<List<CoffeeMenu>>()
    val coffeeHouse = MutableLiveData<Location>()
}