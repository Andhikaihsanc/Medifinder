package com.andhikaihsansapplication.app.modules.onboardingthree.`data`.model

import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.di.MyApp
import kotlin.String

data class OnBoardingThreeModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtYoucanfindco: String? =
      MyApp.getInstance().resources.getString(R.string.msg_you_can_find_co)

)
