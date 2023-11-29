package com.andhikaihsansapplication.app.modules.changename.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivityChangeNameBinding
import com.andhikaihsansapplication.app.modules.changename.`data`.viewmodel.ChangeNameVM
import kotlin.String
import kotlin.Unit

class ChangeNameActivity : BaseActivity<ActivityChangeNameBinding>(R.layout.activity_change_name) {
  private val viewModel: ChangeNameVM by viewModels<ChangeNameVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.changeNameVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "CHANGE_NAME_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ChangeNameActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
