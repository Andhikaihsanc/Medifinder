package com.andhikaihsansapplication.app.modules.login.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EmailVM : ViewModel() {
    private val _email = MutableLiveData<String>()

    val email: LiveData<String> = _email

    fun simpanData(nama: String) {
        _email.value = nama
    }
}
