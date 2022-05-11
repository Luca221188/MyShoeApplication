package com.example.myshoeapp.shoedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myshoeapp.model.Shoe

class ShoeDetailViewModel: ViewModel() {
    private val _newShoe: MutableLiveData<Shoe> = MutableLiveData() //null
    val newShoe: LiveData<Shoe> = _newShoe
}