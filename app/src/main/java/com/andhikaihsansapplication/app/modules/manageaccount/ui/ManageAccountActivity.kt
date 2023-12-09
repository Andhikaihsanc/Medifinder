package com.andhikaihsansapplication.app.modules.manageaccount.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivityManageAccountBinding
import com.andhikaihsansapplication.app.modules.deleteaccconfirmation.ui.DeleteAccConfirmationActivity
import com.andhikaihsansapplication.app.modules.editprofile.ui.EditProfileActivity
import com.andhikaihsansapplication.app.modules.logoutconfirmation.ui.LogoutConfirmationActivity
import com.andhikaihsansapplication.app.modules.mainpage.ui.MainPageActivity
import com.andhikaihsansapplication.app.modules.manageaccount.`data`.viewmodel.ManageAccountVM
import kotlin.String
import kotlin.Unit

class ManageAccountActivity :
    BaseActivity<ActivityManageAccountBinding>(R.layout.activity_manage_account) {
  private val viewModel: ManageAccountVM by viewModels<ManageAccountVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.manageAccountVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearLogout.setOnClickListener {
      val destIntent = LogoutConfirmationActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearDeleteacc.setOnClickListener {
      val destIntent = DeleteAccConfirmationActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageHome.setOnClickListener{
      val destIntent = MainPageActivity.getIntent(this,null)
      startActivity(destIntent)
    }
    binding.imageUser.setOnClickListener{
      val destIntent = EditProfileActivity.getIntent(this,null)
      startActivity(destIntent)
    }
    binding.btnArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "MANAGE_ACCOUNT_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ManageAccountActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
