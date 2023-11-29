package com.andhikaihsansapplication.app.modules.aboutapp.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivityAboutAppBinding
import com.andhikaihsansapplication.app.modules.aboutapp.`data`.viewmodel.AboutAppVM
import kotlin.String
import kotlin.Unit

class AboutAppActivity : BaseActivity<ActivityAboutAppBinding>(R.layout.activity_about_app) {
  private val viewModel: AboutAppVM by viewModels<AboutAppVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.aboutAppVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "ABOUT_APP_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AboutAppActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
