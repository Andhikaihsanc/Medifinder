package com.andhikaihsansapplication.app.modules.changephonenumber.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivityChangePhoneNumberBinding
import com.andhikaihsansapplication.app.modules.changephonenumber.`data`.viewmodel.ChangePhoneNumberVM
import kotlin.String
import kotlin.Unit

class ChangePhoneNumberActivity :
    BaseActivity<ActivityChangePhoneNumberBinding>(R.layout.activity_change_phone_number) {
  private val viewModel: ChangePhoneNumberVM by viewModels<ChangePhoneNumberVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.changePhoneNumberVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "CHANGE_PHONE_NUMBER_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ChangePhoneNumberActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
