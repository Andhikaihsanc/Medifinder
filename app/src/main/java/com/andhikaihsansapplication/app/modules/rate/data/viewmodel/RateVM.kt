package com.andhikaihsansapplication.app.modules.rate.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andhikaihsansapplication.app.modules.rate.`data`.model.RateModel
import org.koin.core.KoinComponent

class RateVM : ViewModel(), KoinComponent {
  val rateModel: MutableLiveData<RateModel> = MutableLiveData(RateModel())

  var navArguments: Bundle? = null
}
