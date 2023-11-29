package com.andhikaihsansapplication.app.modules.aboutapp.`data`.model

import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.di.MyApp
import kotlin.String

data class AboutAppModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtAboutApp: String? = MyApp.getInstance().resources.getString(R.string.lbl_about_app)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtYoucanfindco: String? =
      MyApp.getInstance().resources.getString(R.string.msg_you_can_find_co)

)
