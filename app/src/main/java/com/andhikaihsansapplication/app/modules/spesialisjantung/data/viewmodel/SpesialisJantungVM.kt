package com.andhikaihsansapplication.app.modules.spesialisjantung.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andhikaihsansapplication.app.modules.spesialisjantung.`data`.model.ListbrawijayauniveRowModel
import com.andhikaihsansapplication.app.modules.spesialisjantung.`data`.model.SpesialisJantungModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class SpesialisJantungVM : ViewModel(), KoinComponent {
  val spesialisJantungModel: MutableLiveData<SpesialisJantungModel> =
      MutableLiveData(SpesialisJantungModel())

  var navArguments: Bundle? = null

  val listbrawijayauniveList: MutableLiveData<MutableList<ListbrawijayauniveRowModel>> =
      MutableLiveData(mutableListOf())
}
