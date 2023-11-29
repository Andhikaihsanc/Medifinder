package com.andhikaihsansapplication.app.modules.onboardingone.`data`.model

import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.di.MyApp
import kotlin.String

data class OnBoardingOneModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtWelcomeToMedi: String? =
      MyApp.getInstance().resources.getString(R.string.msg_welcome_to_medi)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSkip: String? = MyApp.getInstance().resources.getString(R.string.lbl_skip)

)
