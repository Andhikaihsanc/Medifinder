package com.andhikaihsansapplication.app.modules.changename.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andhikaihsansapplication.app.modules.changename.`data`.model.ChangeNameModel
import org.koin.core.KoinComponent

class ChangeNameVM : ViewModel(), KoinComponent {
  val changeNameModel: MutableLiveData<ChangeNameModel> = MutableLiveData(ChangeNameModel())

  var navArguments: Bundle? = null
}
