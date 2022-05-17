package com.example.myshoeapp.shoelist

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myshoeapp.model.Shoe

class ShoeListViewModel: ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>() //null
    val shoeList: LiveData<MutableList<Shoe>>
    get() = _shoeList


    private val _addingNewShoeEvent: MutableLiveData<Boolean> = MutableLiveData() //null
    val addingNewShoeEvent: LiveData<Boolean> = _addingNewShoeEvent

    init {
        _shoeList.value = mutableListOf()
        _shoeList.value?.add(Shoe("Converse", 10.0, "All Stars", "Casual Shoes"))
        _shoeList.value?.add(Shoe("Vans", 9.0, "Vans", "Casual Shoes"))

        _addingNewShoeEvent.value = false
    }

    private fun addShoe(newShoeToAdd: Shoe) {
        _shoeList.value?.add(newShoeToAdd)
    }

    fun setNewShoe(newShoe: Shoe?) {
        println("Is adding the new Shoe object an example of EVENT?")
        if (!checkShoeValidity(newShoe)) {
            return
        }else {
            addShoe(newShoe!!)  // Why do I still need !! after already checking for null?
        }
    }

    private fun checkShoeValidity(shoeToCheck: Shoe?): Boolean {
        if (shoeToCheck == null) {
            return false
        }
        _shoeList.value?.forEach { shoeContained ->
            if (shoeContained == shoeToCheck) {
                return false
            }
        }
        return true
    }

    fun onAddingShoeEventOpen() {
        _addingNewShoeEvent.value = true
    }

    fun onAddingShoeEventCompleted() {
        _addingNewShoeEvent.value = false
    }

//    override fun onCleared() {
//        super.onCleared()
//        println("I HAVE BEEN DESTROYED!!!!!!!!!!!!!!!!!")
//    }
}