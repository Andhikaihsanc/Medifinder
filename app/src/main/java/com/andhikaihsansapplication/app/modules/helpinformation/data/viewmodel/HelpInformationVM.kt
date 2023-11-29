package com.andhikaihsansapplication.app.modules.helpinformation.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andhikaihsansapplication.app.modules.helpinformation.`data`.model.HelpInformationModel
import org.koin.core.KoinComponent

class HelpInformationVM : ViewModel(), KoinComponent {
  val helpInformationModel: MutableLiveData<HelpInformationModel> =
      MutableLiveData(HelpInformationModel())

  var navArguments: Bundle? = null
}
