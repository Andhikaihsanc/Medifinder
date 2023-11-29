package com.andhikaihsansapplication.app.modules.manageaccount.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andhikaihsansapplication.app.modules.manageaccount.`data`.model.ManageAccountModel
import org.koin.core.KoinComponent

class ManageAccountVM : ViewModel(), KoinComponent {
  val manageAccountModel: MutableLiveData<ManageAccountModel> =
      MutableLiveData(ManageAccountModel())

  var navArguments: Bundle? = null
}
