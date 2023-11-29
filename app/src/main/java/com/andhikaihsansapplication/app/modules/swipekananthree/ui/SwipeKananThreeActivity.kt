package com.andhikaihsansapplication.app.modules.swipekananthree.ui

import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivitySwipeKananThreeBinding
import com.andhikaihsansapplication.app.modules.swipekananthree.`data`.viewmodel.SwipeKananThreeVM
import kotlin.String
import kotlin.Unit

class SwipeKananThreeActivity :
    BaseActivity<ActivitySwipeKananThreeBinding>(R.layout.activity_swipe_kanan_three) {
  private val viewModel: SwipeKananThreeVM by viewModels<SwipeKananThreeVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.swipeKananThreeVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "SWIPE_KANAN_THREE_ACTIVITY"

  }
}
