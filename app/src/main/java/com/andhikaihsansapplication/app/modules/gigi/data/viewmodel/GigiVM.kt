package com.andhikaihsansapplication.app.modules.gigi.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andhikaihsansapplication.app.modules.gigi.`data`.model.GigiModel
import com.andhikaihsansapplication.app.modules.gigi.`data`.model.GigiRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class GigiVM : ViewModel(), KoinComponent {
  val gigiModel: MutableLiveData<GigiModel> = MutableLiveData(GigiModel())

  var navArguments: Bundle? = null

  val gigiList: MutableLiveData<MutableList<GigiRowModel>> = MutableLiveData(mutableListOf())
}
