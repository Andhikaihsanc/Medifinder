package com.andhikaihsansapplication.app.modules.listtodetail.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andhikaihsansapplication.app.modules.listtodetail.`data`.model.ListToDetailModel
import org.koin.core.KoinComponent

class ListToDetailVM : ViewModel(), KoinComponent {
  val listToDetailModel: MutableLiveData<ListToDetailModel> = MutableLiveData(ListToDetailModel())

  var navArguments: Bundle? = null
}
