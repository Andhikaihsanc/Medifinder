package com.andhikaihsansapplication.app.modules.manageaccount.`data`.model

import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.di.MyApp
import kotlin.String

data class ManageAccountModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtManageAccounts: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_manage_accounts)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLogOut: String? = MyApp.getInstance().resources.getString(R.string.lbl_log_out)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDeleteAccount: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_delete_account)

)
