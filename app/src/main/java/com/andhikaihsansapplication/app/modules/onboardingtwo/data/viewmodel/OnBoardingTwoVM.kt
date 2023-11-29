package com.andhikaihsansapplication.app.modules.onboardingtwo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andhikaihsansapplication.app.modules.onboardingtwo.`data`.model.OnBoardingTwoModel
import org.koin.core.KoinComponent

class OnBoardingTwoVM : ViewModel(), KoinComponent {
  val onBoardingTwoModel: MutableLiveData<OnBoardingTwoModel> =
      MutableLiveData(OnBoardingTwoModel())

  var navArguments: Bundle? = null
}
