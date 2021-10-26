package com.example.helloworldcompose.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    private val nombre = MutableLiveData("")

    fun nombre() : LiveData<String> = nombre

    fun cambiarNombre(name : String) {
        nombre.postValue(name)
    }
}