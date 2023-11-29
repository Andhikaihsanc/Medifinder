package com.andhikaihsansapplication.app.modules.onboardingtwo.`data`.model

import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.di.MyApp
import kotlin.String

data class OnBoardingTwoModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtYoucanfindth: String? =
      MyApp.getInstance().resources.getString(R.string.msg_you_can_find_th)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSkip: String? = MyApp.getInstance().resources.getString(R.string.lbl_skip)

)
