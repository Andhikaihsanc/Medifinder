package com.andhikaihsansapplication.app.modules.credentials.`data`.model

import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.di.MyApp
import kotlin.String

data class CredentialsModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtNewCredentials: String? =
      MyApp.getInstance().resources.getString(R.string.msg_new_credential)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtYouridentityh: String? =
      MyApp.getInstance().resources.getString(R.string.msg_your_identity_h)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtNewPassword: String? = MyApp.getInstance().resources.getString(R.string.lbl_new_password)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtConfirmPasswor: String? =
      MyApp.getInstance().resources.getString(R.string.msg_confirm_passwor)

)
