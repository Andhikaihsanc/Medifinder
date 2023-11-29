package com.andhikaihsansapplication.app.modules.rate.`data`.model

import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.di.MyApp
import kotlin.String

data class RateModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtRateMediFinder: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_rate_medifinder)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtYouropinionma: String? =
      MyApp.getInstance().resources.getString(R.string.msg_your_opinion_ma)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtWeworksuperh: String? =
      MyApp.getInstance().resources.getString(R.string.msg_we_work_super_h)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtNothanks: String? = MyApp.getInstance().resources.getString(R.string.lbl_no_thanks)

)
