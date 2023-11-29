package com.andhikaihsansapplication.app.modules.spesialisjantung.`data`.model

import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.di.MyApp
import kotlin.String

data class ListbrawijayauniveRowModel(
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

)
