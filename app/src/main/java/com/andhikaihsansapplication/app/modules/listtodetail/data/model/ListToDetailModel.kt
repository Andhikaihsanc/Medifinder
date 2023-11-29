package com.andhikaihsansapplication.app.modules.listtodetail.`data`.model

import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.di.MyApp
import kotlin.String

data class ListToDetailModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtSettings: String? = MyApp.getInstance().resources.getString(R.string.lbl_settings)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtVerizcaMaudia: String? =
      MyApp.getInstance().resources.getString(R.string.msg_verizca_maudia)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txt62858123456: String? = MyApp.getInstance().resources.getString(R.string.msg_62_858_1234_56)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEmail: String? = MyApp.getInstance().resources.getString(R.string.msg_rischamaudya03)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtManageAccount: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_manage_account)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHelpCenter: String? = MyApp.getInstance().resources.getString(R.string.lbl_help_center)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAboutApp: String? = MyApp.getInstance().resources.getString(R.string.lbl_about_app)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtRateMediFinder: String? =
      MyApp.getInstance().resources.getString(R.string.msg_rate_medifinder)

)
