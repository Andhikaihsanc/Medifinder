package com.andhikaihsansapplication.app.modules.deleteaccconfirmation.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.andhikaihsansapplication.app.modules.deleteaccconfirmation.`data`.model.DeleteAccConfirmationModel
import org.koin.core.KoinComponent

class DeleteAccConfirmationVM : ViewModel(), KoinComponent {
  val deleteAccConfirmationModel: MutableLiveData<DeleteAccConfirmationModel> =
      MutableLiveData(DeleteAccConfirmationModel())

  var navArguments: Bundle? = null
}
