package com.andhikaihsansapplication.app.modules.swipekanantwo.`data`.model

import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.di.MyApp
import kotlin.String

data class SwipeKananTwoModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtNearestHospita: String? =
      MyApp.getInstance().resources.getString(R.string.msg_nearest_hospita),
  /**
   * TODO Replace with dynamic value
   */
  var txtFindHospital: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_find_hospital)
)