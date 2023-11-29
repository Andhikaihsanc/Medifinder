package com.andhikaihsansapplication.app.modules.splashscreen.`data`.model

import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.di.MyApp
import kotlin.String

data class SplashScreenModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtEmergency: String? = MyApp.getInstance().resources.getString(R.string.lbl_emergency)

)
