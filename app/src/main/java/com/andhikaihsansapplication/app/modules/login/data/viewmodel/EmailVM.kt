package com.andhikaihsansapplication.app.modules.login.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EmailVM : ViewModel() {
    val mutableString: MutableLiveData<String> = MutableLiveData("")

    fun updateValue(newValue: String) {
        mutableString.value = newValue // setValue(newValue) juga dapat digunakan di UI thread
        // mutableString.postValue(newValue) digunakan untuk dipanggil dari luar UI thread
    }
}
