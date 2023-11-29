package com.andhikaihsansapplication.app.modules.onboardingone.`data`.model

import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.di.MyApp
import kotlin.String

data class ListsearchRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtFindNearestHo: String? =
      MyApp.getInstance().resources.getString(R.string.msg_find_nearest_ho)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFindtheneares: String? =
      MyApp.getInstance().resources.getString(R.string.msg_find_the_neares)

)
