package com.andhikaihsansapplication.app.modules.spesialisjantung.recyclerHandler

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RumahSakitViewModel : ViewModel() {
    private val _rumahSakitList = MutableLiveData<MutableSet<RumahSakit>>()
    val rumahSakitList: LiveData<MutableSet<RumahSakit>> = _rumahSakitList

    init {
        _rumahSakitList.value = mutableSetOf()
    }

    fun tambahRumahSakitList(newRumahSakitList: List<RumahSakit>) {
//        val currentList = _rumahSakitList.value ?: mutableSetOf()
        val currentList = mutableSetOf<RumahSakit>()
        currentList.addAll(newRumahSakitList)
        _rumahSakitList.value = currentList
    }

    fun gantiRumahSakitList(newRumahSakitList: List<RumahSakit>){
        _rumahSakitList.value?.apply {
            clear() // Menghapus seluruh elemen dari list
            addAll(newRumahSakitList) // Menambahkan elemen-elemen baru
        }
    }
}
