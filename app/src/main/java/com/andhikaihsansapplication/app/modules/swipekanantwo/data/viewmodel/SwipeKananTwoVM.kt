package com.andhikaihsansapplication.app.modules.swipekanantwo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andhikaihsansapplication.app.modules.swipekanantwo.`data`.model.SwipeKananTwoModel
import org.koin.core.KoinComponent

class SwipeKananTwoVM : ViewModel(), KoinComponent {
  val swipeKananTwoModel: MutableLiveData<SwipeKananTwoModel> =
      MutableLiveData(SwipeKananTwoModel())

  var navArguments: Bundle? = null
}
