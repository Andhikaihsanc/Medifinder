package com.andhikaihsansapplication.app.modules.login.`data`.model

import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.di.MyApp
import kotlin.String

data class LoginModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLOGIN: String? = MyApp.getInstance().resources.getString(R.string.lbl_login3)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtUsername: String? = MyApp.getInstance().resources.getString(R.string.lbl_username)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPassword: String? = MyApp.getInstance().resources.getString(R.string.lbl_password)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLoginOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_login2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtForgottenYour: String? =
      MyApp.getInstance().resources.getString(R.string.msg_forgotten_your)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDonthaveany: String? = MyApp.getInstance().resources.getString(R.string.msg_don_t_have_any)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtResister: String? = MyApp.getInstance().resources.getString(R.string.lbl_register2)

)
