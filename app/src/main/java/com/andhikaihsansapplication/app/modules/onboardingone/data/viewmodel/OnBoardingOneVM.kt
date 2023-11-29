package com.andhikaihsansapplication.app.modules.onboardingone.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andhikaihsansapplication.app.modules.onboardingone.`data`.model.ListsearchRowModel
import com.andhikaihsansapplication.app.modules.onboardingone.`data`.model.OnBoardingOneModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class OnBoardingOneVM : ViewModel(), KoinComponent {
  val onBoardingOneModel: MutableLiveData<OnBoardingOneModel> =
      MutableLiveData(OnBoardingOneModel())

  var navArguments: Bundle? = null

  val listsearchList: MutableLiveData<MutableList<ListsearchRowModel>> =
      MutableLiveData(mutableListOf())
}
