package com.example.myshoeapp.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myshoeapp.model.Shoe

class ShoeListViewModel: ViewModel() {

    private val _shoeList: MutableLiveData<MutableList<Shoe>> = MutableLiveData()
    val shoeList: LiveData<MutableList<Shoe>> = _shoeList

    init {
        _shoeList.value?.add(Shoe("Converse", 10.0, "All Stars", "Casual Shoes"))
        _shoeList.value?.add(Shoe("Vans", 9.0, "Vans", "Casual Shoes"))
    }

}