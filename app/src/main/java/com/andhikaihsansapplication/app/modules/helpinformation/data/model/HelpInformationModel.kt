package com.andhikaihsansapplication.app.modules.helpinformation.`data`.model

import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.di.MyApp
import kotlin.String

data class HelpInformationModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtHelpCentre: String? = MyApp.getInstance().resources.getString(R.string.lbl_help_centre)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtYoucanfindco: String? =
      MyApp.getInstance().resources.getString(R.string.msg_you_can_find_co)

)
