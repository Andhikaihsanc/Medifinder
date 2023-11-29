package com.andhikaihsansapplication.app.modules.onboardingthree.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivityOnBoardingThreeBinding
import com.andhikaihsansapplication.app.modules.login.ui.LoginActivity
import com.andhikaihsansapplication.app.modules.onboardingthree.`data`.viewmodel.OnBoardingThreeVM
import com.andhikaihsansapplication.app.modules.register.ui.RegisterActivity
import com.andhikaihsansapplication.app.modules.swipekanan.ui.SwipeKananActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class OnBoardingThreeActivity :
    BaseActivity<ActivityOnBoardingThreeBinding>(R.layout.activity_on_boarding_three) {
  private val viewModel: OnBoardingThreeVM by viewModels<OnBoardingThreeVM>()

  private val REQUEST_CODE_SWIPE_KANAN_ACTIVITY: Int = 843

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.onBoardingThreeVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnLogIn.setOnClickListener {
      val destIntent = LoginActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnCreateNewAccount.setOnClickListener {
      val destIntent = RegisterActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "ON_BOARDING_THREE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, OnBoardingThreeActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
