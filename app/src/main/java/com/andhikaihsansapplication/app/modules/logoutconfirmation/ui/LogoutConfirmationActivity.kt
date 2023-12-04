package com.andhikaihsansapplication.app.modules.logoutconfirmation.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivityLogoutConfirmationBinding
import com.andhikaihsansapplication.app.modules.logoutconfirmation.`data`.viewmodel.LogoutConfirmationVM
import com.andhikaihsansapplication.app.modules.splashscreen.ui.SplashScreenActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlin.String
import kotlin.Unit

class LogoutConfirmationActivity :
    BaseActivity<ActivityLogoutConfirmationBinding>(R.layout.activity_logout_confirmation) {
  private val viewModel: LogoutConfirmationVM by viewModels<LogoutConfirmationVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.logoutConfirmationVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnYesImSure.setOnClickListener {
      val auth = FirebaseAuth.getInstance()
      auth.signOut()

      val destIntent = SplashScreenActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnNo.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "LOGOUT_CONFIRMATION_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, LogoutConfirmationActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
