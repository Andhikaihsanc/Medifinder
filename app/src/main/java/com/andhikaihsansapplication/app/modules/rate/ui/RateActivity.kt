package com.andhikaihsansapplication.app.modules.rate.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivityRateBinding
import com.andhikaihsansapplication.app.modules.listtodetail.ui.ListToDetailActivity
import com.andhikaihsansapplication.app.modules.rate.`data`.viewmodel.RateVM
import kotlin.String
import kotlin.Unit

class RateActivity : BaseActivity<ActivityRateBinding>(R.layout.activity_rate) {
  private val viewModel: RateVM by viewModels<RateVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.rateVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtNothanks.setOnClickListener {
      val destIntent = ListToDetailActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnSubmit.setOnClickListener {
      val destIntent = ListToDetailActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "RATE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, RateActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
