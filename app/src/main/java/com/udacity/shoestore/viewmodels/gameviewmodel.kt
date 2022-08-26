package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class GameViewModel: ViewModel() {

    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes
    private val _nav = MutableLiveData<Boolean>()
    val nav: LiveData<Boolean>
        get() = _nav

    val name = MutableLiveData<String>()
    val size = MutableLiveData<String>()
    val company = MutableLiveData<String>()
    val desc = MutableLiveData<String>()

       init {
        Timber.d("i am here")
    }
    fun additem() {
        val s = mutableListOf<Shoe>()
        val sh=Shoe(name = name.value.toString(), size = size.value.toString(), company = company.value.toString(),description=desc.value.toString())
        _shoes.value?.forEach { i ->
            s.add(i)
        }
        s.add(sh)
        _shoes.value=s
        Timber.d("this value ${_shoes.value}")
        _nav.value=true

        name.value=""
        size.value=""
        desc.value=""
        company.value=""
    }
    fun onnav(){
        _nav.value=false
    }
}