package com.andhikaihsansapplication.app.modules.spesialisjantung.recyclerHandler

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//class RumahSakitViewModel : ViewModel() {
//    private val _rumahSakitList = MutableLiveData<MutableList<RumahSakit>?>()
//    val rumahSakitList: MutableLiveData<MutableList<RumahSakit>?> = _rumahSakitList
//
//    init {
//        _rumahSakitList.value = mutableListOf()
//    }
//
//    fun tambahRumahSakit(rumahSakit: RumahSakit) {
//        val currentList = _rumahSakitList.value
//        currentList?.add(rumahSakit)
//        _rumahSakitList.value = currentList
//    }
//}

class RumahSakitViewModel : ViewModel() {
    private val _rumahSakitList = MutableLiveData<MutableList<RumahSakit>>()
    val rumahSakitList: LiveData<MutableList<RumahSakit>> = _rumahSakitList

    init {
        _rumahSakitList.value = mutableListOf()
    }

    fun tambahRumahSakitList(newRumahSakitList: List<RumahSakit>) {
        val currentList = _rumahSakitList.value ?: mutableListOf()
        currentList.addAll(newRumahSakitList)
        _rumahSakitList.value = currentList
    }
}
