package com.andhikaihsansapplication.app.modules.splashscreen.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivitySplashScreenBinding
import com.andhikaihsansapplication.app.modules.mainpage.ui.MainPageActivity
import com.andhikaihsansapplication.app.modules.onboardingone.ui.OnBoardingOneActivity
import com.andhikaihsansapplication.app.modules.spesialisjantung.ui.SpesialisJantungActivity
import com.andhikaihsansapplication.app.modules.splashscreen.`data`.viewmodel.SplashScreenVM
import com.andhikaihsansapplication.app.modules.swipekanan.ui.SwipeKananActivity
import com.andhikaihsansapplication.app.modules.swipekanantwo.ui.SwipeKananTwoActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import kotlin.String
import kotlin.Unit

class SplashScreenActivity :
    BaseActivity<ActivitySplashScreenBinding>(R.layout.activity_splash_screen) {
  private val viewModel: SplashScreenVM by viewModels<SplashScreenVM>()

  private val REQUEST_CODE_SPESIALIS_JANTUNG_ACTIVITY: Int = 216

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.splashScreenVM = viewModel
    }

    override fun setUpClicks(): Unit {
      binding.btnNext.setOnClickListener {
        val user = Firebase.auth.currentUser

        if (user != null) {
          val destIntent = MainPageActivity.getIntent(this, null)
          startActivity(destIntent)
          this.overridePendingTransition(R.anim.right_to_left ,0 )
          // User is signed in
        } else {
          val destIntent = OnBoardingOneActivity.getIntent(this, null)
          startActivity(destIntent)
          this.overridePendingTransition(R.anim.right_to_left ,0 )
          // No user is signed in
        }

      }

      binding.btnEmergencyalert.setOnClickListener{
        val destIntent = SpesialisJantungActivity.getIntent(this,null)
        startActivity(destIntent)
      }

      binding.txtEmergency.setOnClickListener{
        val destIntent = SwipeKananActivity.getIntent(this,null)
        startActivity(destIntent)
      }

//      binding.btnEmergencyalert.setOnClickListener{
//        val destIntent = SwipeKananActivity.getIntent(this, null)
//        destIntent.putExtra("CURRENT_KATEGORI", "makanan")
//        startActivityForResult(destIntent, REQUEST_CODE_SPESIALIS_JANTUNG_ACTIVITY)
//      }
    }



    companion object {
      const val TAG: String = "SPLASH_SCREEN_ACTIVITY"


      fun getIntent(context: Context, bundle: Bundle?): Intent {
        val destIntent = Intent(context, SplashScreenActivity::class.java)
        destIntent.putExtra("bundle", bundle)
        return destIntent
      }
    }
  }
