package com.andhikaihsansapplication.app.modules.swipekanan.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andhikaihsansapplication.app.modules.swipekanan.`data`.model.SwipeKananModel
import org.koin.core.KoinComponent

class SwipeKananVM : ViewModel(), KoinComponent {
  val swipeKananModel: MutableLiveData<SwipeKananModel> = MutableLiveData(SwipeKananModel())

  var navArguments: Bundle? = null
}
