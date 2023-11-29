package com.andhikaihsansapplication.app.modules.mainpage.`data`.model

import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.di.MyApp
import kotlin.String

data class MainPageModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtWelcomeVerizc: String? =
      MyApp.getInstance().resources.getString(R.string.msg_welcome_verizc)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtRecommended: String? = MyApp.getInstance().resources.getString(R.string.lbl_recommended)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtBrawijayaUnive: String? =
      MyApp.getInstance().resources.getString(R.string.msg_brawijaya_unive)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTimeZone: String? = MyApp.getInstance().resources.getString(R.string.msg_soekarno_hatt)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txt0341403000: String? = MyApp.getInstance().resources.getString(R.string.lbl_0341_403000)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDrSaifulAnwa: String? =
      MyApp.getInstance().resources.getString(R.string.msg_dr_saiful_anwa)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTimeZoneOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_jaksa_agung_sup)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txt0341362101: String? = MyApp.getInstance().resources.getString(R.string.lbl_0341_362101)

)
