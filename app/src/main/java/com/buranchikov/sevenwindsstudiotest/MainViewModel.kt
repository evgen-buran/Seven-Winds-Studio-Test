package com.buranchikov.sevenwindsstudiotest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buranchikov.sevenwindsstudiotest.data_classes.Product
import com.buranchikov.sevenwindsstudiotest.data_classes.Location
import com.buranchikov.sevenwindsstudiotest.data_classes.Order

class MainViewModel : ViewModel() {
    val token = MutableLiveData<String>()
    val location = MutableLiveData<List<Location>>()
    val menu = MutableLiveData<List<Product>>()
    val coffeeHouse = MutableLiveData<Location>()
    val listOrder = MutableLiveData<List<Order>>()
}