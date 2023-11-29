package com.andhikaihsansapplication.app.modules.changephonenumber.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andhikaihsansapplication.app.modules.changephonenumber.`data`.model.ChangePhoneNumberModel
import org.koin.core.KoinComponent

class ChangePhoneNumberVM : ViewModel(), KoinComponent {
  val changePhoneNumberModel: MutableLiveData<ChangePhoneNumberModel> =
      MutableLiveData(ChangePhoneNumberModel())

  var navArguments: Bundle? = null
}
