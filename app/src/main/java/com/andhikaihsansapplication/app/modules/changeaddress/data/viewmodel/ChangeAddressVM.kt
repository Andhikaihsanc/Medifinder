package com.andhikaihsansapplication.app.modules.changeaddress.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andhikaihsansapplication.app.modules.changeaddress.`data`.model.ChangeAddressModel
import org.koin.core.KoinComponent

class ChangeAddressVM : ViewModel(), KoinComponent {
  val changeAddressModel: MutableLiveData<ChangeAddressModel> =
      MutableLiveData(ChangeAddressModel())

  var navArguments: Bundle? = null
}
