package com.andhikaihsansapplication.app.modules.swipekanan.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivitySwipeKananBinding
import com.andhikaihsansapplication.app.modules.swipekanan.`data`.viewmodel.SwipeKananVM
import com.andhikaihsansapplication.app.modules.swipekanantwo.ui.SwipeKananTwoActivity
import kotlin.String
import kotlin.Unit

class SwipeKananActivity : BaseActivity<ActivitySwipeKananBinding>(R.layout.activity_swipe_kanan) {
  private val viewModel: SwipeKananVM by viewModels<SwipeKananVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.swipeKananVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnNext.setOnClickListener {
      val destIntent = SwipeKananTwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "SWIPE_KANAN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SwipeKananActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
