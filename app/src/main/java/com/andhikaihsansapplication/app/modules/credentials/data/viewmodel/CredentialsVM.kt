package com.andhikaihsansapplication.app.modules.credentials.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andhikaihsansapplication.app.modules.credentials.`data`.model.CredentialsModel
import org.koin.core.KoinComponent

class CredentialsVM : ViewModel(), KoinComponent {
  val credentialsModel: MutableLiveData<CredentialsModel> = MutableLiveData(CredentialsModel())

  var navArguments: Bundle? = null
}
