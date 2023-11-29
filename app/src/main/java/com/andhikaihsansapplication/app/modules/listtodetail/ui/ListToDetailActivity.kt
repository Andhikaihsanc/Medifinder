package com.andhikaihsansapplication.app.modules.listtodetail.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivityListToDetailBinding
import com.andhikaihsansapplication.app.modules.aboutapp.ui.AboutAppActivity
import com.andhikaihsansapplication.app.modules.editprofile.ui.EditProfileActivity
import com.andhikaihsansapplication.app.modules.helpinformation.ui.HelpInformationActivity
import com.andhikaihsansapplication.app.modules.listtodetail.`data`.viewmodel.ListToDetailVM
import com.andhikaihsansapplication.app.modules.mainpage.ui.MainPageActivity
import com.andhikaihsansapplication.app.modules.manageaccount.ui.ManageAccountActivity
import com.andhikaihsansapplication.app.modules.rate.ui.RateActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class ListToDetailActivity :
    BaseActivity<ActivityListToDetailBinding>(R.layout.activity_list_to_detail) {
  private val viewModel: ListToDetailVM by viewModels<ListToDetailVM>()

  private val REQUEST_CODE_MAIN_PAGE_ACTIVITY: Int = 332


  private val REQUEST_CODE_EDIT_PROFILE_ACTIVITY: Int = 224


  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.listToDetailVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.linearRate.setOnClickListener {
      val destIntent = RateActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageHome.setOnClickListener {
      val destIntent = MainPageActivity.getIntent(this, null)
      startActivityForResult(destIntent, REQUEST_CODE_MAIN_PAGE_ACTIVITY)
    }
    binding.imageEdit.setOnClickListener {
      val destIntent = EditProfileActivity.getIntent(this, null)
      startActivityForResult(destIntent, REQUEST_CODE_EDIT_PROFILE_ACTIVITY)
    }
    binding.imageUserOne.setOnClickListener {
      val destIntent = EditProfileActivity.getIntent(this, null)
      startActivityForResult(destIntent, REQUEST_CODE_EDIT_PROFILE_ACTIVITY)
    }
    binding.linearHelp.setOnClickListener {
      val destIntent = HelpInformationActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearManageacc.setOnClickListener {
      val destIntent = ManageAccountActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearAboutApp.setOnClickListener{
      val destIntent = AboutAppActivity.getIntent(this,null)
      startActivity(destIntent)
    }
    binding.btnArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "LIST_TO_DETAIL_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ListToDetailActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
