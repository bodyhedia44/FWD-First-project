package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class GameViewModel: ViewModel() {
    init {
        Timber.d("i am here")
    }
    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    fun additem(shoe: Shoe) {
        val s = mutableListOf<Shoe>()

        _shoes.value?.forEach { i ->
            s.add(i)
        }
        s.add(shoe)
        _shoes.value=s
        Timber.d("this value ${_shoes.value}")
    }
}