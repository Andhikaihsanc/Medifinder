package com.andhikaihsansapplication.app.modules.aboutapp.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andhikaihsansapplication.app.modules.aboutapp.`data`.model.AboutAppModel
import org.koin.core.KoinComponent

class AboutAppVM : ViewModel(), KoinComponent {
  val aboutAppModel: MutableLiveData<AboutAppModel> = MutableLiveData(AboutAppModel())

  var navArguments: Bundle? = null
}
