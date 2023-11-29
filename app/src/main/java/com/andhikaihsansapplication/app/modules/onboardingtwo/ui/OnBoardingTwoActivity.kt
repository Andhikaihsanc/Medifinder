package com.andhikaihsansapplication.app.modules.onboardingtwo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivityOnBoardingTwoBinding
import com.andhikaihsansapplication.app.modules.onboardingthree.ui.OnBoardingThreeActivity
import com.andhikaihsansapplication.app.modules.onboardingtwo.`data`.viewmodel.OnBoardingTwoVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class OnBoardingTwoActivity :
    BaseActivity<ActivityOnBoardingTwoBinding>(R.layout.activity_on_boarding_two) {
  private val viewModel: OnBoardingTwoVM by viewModels<OnBoardingTwoVM>()

  private val REQUEST_CODE_ON_BOARDING_THREE_ACTIVITY: Int = 208

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.onBoardingTwoVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtSkip.setOnClickListener {
      val destIntent = OnBoardingThreeActivity.getIntent(this, null)
      startActivityForResult(destIntent, REQUEST_CODE_ON_BOARDING_THREE_ACTIVITY)
    }
    binding.imageArrowright.setOnClickListener {
      val destIntent = OnBoardingThreeActivity.getIntent(this, null)
      startActivityForResult(destIntent, REQUEST_CODE_ON_BOARDING_THREE_ACTIVITY)
    }
    binding.btnContinue.setOnClickListener {
      val destIntent = OnBoardingThreeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "ON_BOARDING_TWO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, OnBoardingTwoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
