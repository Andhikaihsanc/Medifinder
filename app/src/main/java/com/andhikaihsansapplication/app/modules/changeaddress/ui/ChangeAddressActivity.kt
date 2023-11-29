package com.andhikaihsansapplication.app.modules.changeaddress.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivityChangeAddressBinding
import com.andhikaihsansapplication.app.modules.changeaddress.`data`.viewmodel.ChangeAddressVM
import kotlin.String
import kotlin.Unit

class ChangeAddressActivity :
    BaseActivity<ActivityChangeAddressBinding>(R.layout.activity_change_address) {
  private val viewModel: ChangeAddressVM by viewModels<ChangeAddressVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.changeAddressVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "CHANGE_ADDRESS_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ChangeAddressActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
