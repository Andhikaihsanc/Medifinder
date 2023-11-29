package com.andhikaihsansapplication.app.modules.credentials.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivityCredentialsBinding
import com.andhikaihsansapplication.app.modules.credentials.`data`.viewmodel.CredentialsVM
import com.andhikaihsansapplication.app.modules.updated.ui.UpdatedActivity
import kotlin.String
import kotlin.Unit

class CredentialsActivity : BaseActivity<ActivityCredentialsBinding>(R.layout.activity_credentials)
    {
  private val viewModel: CredentialsVM by viewModels<CredentialsVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.credentialsVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnUpdate.setOnClickListener {
      val destIntent = UpdatedActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "CREDENTIALS_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, CredentialsActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
