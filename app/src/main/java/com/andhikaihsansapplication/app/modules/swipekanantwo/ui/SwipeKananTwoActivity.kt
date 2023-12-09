package com.andhikaihsansapplication.app.modules.swipekanantwo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivitySwipeKananTwoBinding
import com.andhikaihsansapplication.app.modules.spesialisjantung.recyclerHandler.RumahSakit
import com.andhikaihsansapplication.app.modules.spesialisjantung.recyclerHandler.RumahSakitClickListener
import com.andhikaihsansapplication.app.modules.swipekanantwo.`data`.viewmodel.SwipeKananTwoVM
import kotlin.String
import kotlin.Unit

class SwipeKananTwoActivity :
    BaseActivity<ActivitySwipeKananTwoBinding>(R.layout.activity_swipe_kanan_two), RumahSakitClickListener {
  private val viewModel: SwipeKananTwoVM by viewModels<SwipeKananTwoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.swipeKananTwoVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "SWIPE_KANAN_TWO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SwipeKananTwoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }

  override fun onRumahSakitClicked(rumahSakit: RumahSakit) {
    TODO("Not yet implemented")
  }
}
