package com.andhikaihsansapplication.app.modules.updated.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andhikaihsansapplication.app.modules.updated.`data`.model.UpdatedModel
import org.koin.core.KoinComponent

class UpdatedVM : ViewModel(), KoinComponent {
  val updatedModel: MutableLiveData<UpdatedModel> = MutableLiveData(UpdatedModel())

  var navArguments: Bundle? = null
}
