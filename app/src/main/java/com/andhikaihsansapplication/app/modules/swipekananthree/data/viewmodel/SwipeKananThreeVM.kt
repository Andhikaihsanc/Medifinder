package com.andhikaihsansapplication.app.modules.swipekananthree.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andhikaihsansapplication.app.modules.swipekananthree.`data`.model.SwipeKananThreeModel
import org.koin.core.KoinComponent

class SwipeKananThreeVM : ViewModel(), KoinComponent {
  val swipeKananThreeModel: MutableLiveData<SwipeKananThreeModel> =
      MutableLiveData(SwipeKananThreeModel())

  var navArguments: Bundle? = null
}
