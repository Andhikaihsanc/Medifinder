package com.andhikaihsansapplication.app.modules.deleteaccconfirmation.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivityDeleteAccConfirmationBinding
import com.andhikaihsansapplication.app.modules.deleteaccconfirmation.`data`.viewmodel.DeleteAccConfirmationVM
import com.andhikaihsansapplication.app.modules.splashscreen.ui.SplashScreenActivity
import kotlin.String
import kotlin.Unit

class DeleteAccConfirmationActivity :
    BaseActivity<ActivityDeleteAccConfirmationBinding>(R.layout.activity_delete_acc_confirmation) {
  private val viewModel: DeleteAccConfirmationVM by viewModels<DeleteAccConfirmationVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.deleteAccConfirmationVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnNo.setOnClickListener {
      finish()
    }
    binding.btnYesImSure.setOnClickListener {
      val destIntent = SplashScreenActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "DELETE_ACC_CONFIRMATION_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, DeleteAccConfirmationActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
