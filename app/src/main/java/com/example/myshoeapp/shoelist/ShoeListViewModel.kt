package com.example.myshoeapp.shoelist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myshoeapp.model.Shoe

class ShoeListViewModel: ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>() //null
    val shoeList: LiveData<MutableList<Shoe>>
    get() = _shoeList

    init {
        _shoeList.value = mutableListOf()
        _shoeList.value?.add(Shoe("Converse", 10.0, "All Stars", "Casual Shoes"))
        _shoeList.value?.add(Shoe("Vans", 9.0, "Vans", "Casual Shoes"))
    }

}