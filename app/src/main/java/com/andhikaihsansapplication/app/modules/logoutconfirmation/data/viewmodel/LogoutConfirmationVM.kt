package com.andhikaihsansapplication.app.modules.logoutconfirmation.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andhikaihsansapplication.app.modules.logoutconfirmation.`data`.model.LogoutConfirmationModel
import org.koin.core.KoinComponent

class LogoutConfirmationVM : ViewModel(), KoinComponent {
  val logoutConfirmationModel: MutableLiveData<LogoutConfirmationModel> =
      MutableLiveData(LogoutConfirmationModel())

  var navArguments: Bundle? = null
}
