package com.andhikaihsansapplication.app.modules.updated.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivityUpdatedBinding
import com.andhikaihsansapplication.app.modules.login.ui.LoginActivity
import com.andhikaihsansapplication.app.modules.updated.`data`.viewmodel.UpdatedVM
import kotlin.String
import kotlin.Unit

class UpdatedActivity : BaseActivity<ActivityUpdatedBinding>(R.layout.activity_updated) {
  private val viewModel: UpdatedVM by viewModels<UpdatedVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.updatedVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtSendlink.setOnClickListener {
      val destIntent = LoginActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "UPDATED_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, UpdatedActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
