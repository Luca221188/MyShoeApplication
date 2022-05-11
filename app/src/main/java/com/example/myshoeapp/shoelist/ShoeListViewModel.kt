package com.example.myshoeapp.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myshoeapp.model.Shoe

class ShoeListViewModel: ViewModel() {
//add a 'shoe' variable; it starts as null. When u send the Shoe item from DetailScreen u update the
    // list with LiveData
    private val _shoeList = MutableLiveData<MutableList<Shoe>>() //null
    val shoeList: LiveData<MutableList<Shoe>>
    get() = _shoeList

    private val _newShoe: MutableLiveData<Shoe> = MutableLiveData() //null
    val newShoe: LiveData<Shoe> = _newShoe

    init {
        _shoeList.value = mutableListOf()
        _shoeList.value?.add(Shoe("Converse", 10.0, "All Stars", "Casual Shoes"))
        _shoeList.value?.add(Shoe("Vans", 9.0, "Vans", "Casual Shoes"))
    }

}