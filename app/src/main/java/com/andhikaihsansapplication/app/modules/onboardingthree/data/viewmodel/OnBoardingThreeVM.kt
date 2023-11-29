package com.andhikaihsansapplication.app.modules.onboardingthree.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andhikaihsansapplication.app.modules.onboardingthree.`data`.model.OnBoardingThreeModel
import org.koin.core.KoinComponent

class OnBoardingThreeVM : ViewModel(), KoinComponent {
  val onBoardingThreeModel: MutableLiveData<OnBoardingThreeModel> =
      MutableLiveData(OnBoardingThreeModel())

  var navArguments: Bundle? = null
}
