package com.andhikaihsansapplication.app.modules.updated.`data`.model

import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.di.MyApp
import kotlin.String

data class UpdatedModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtYourpasswordh: String? =
      MyApp.getInstance().resources.getString(R.string.msg_your_password_h)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPasswordUpdate: String? =
      MyApp.getInstance().resources.getString(R.string.msg_password_update)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSendlink: String? = MyApp.getInstance().resources.getString(R.string.lbl_login2)

)
