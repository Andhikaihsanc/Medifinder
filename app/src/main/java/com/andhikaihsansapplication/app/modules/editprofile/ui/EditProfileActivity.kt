package com.andhikaihsansapplication.app.modules.editprofile.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.appcomponents.views.ImagePickerFragmentDialog
import com.andhikaihsansapplication.app.databinding.ActivityEditProfileBinding
import com.andhikaihsansapplication.app.modules.changeaddress.ui.ChangeAddressActivity
import com.andhikaihsansapplication.app.modules.changename.ui.ChangeNameActivity
import com.andhikaihsansapplication.app.modules.changephonenumber.ui.ChangePhoneNumberActivity
import com.andhikaihsansapplication.app.modules.editprofile.`data`.viewmodel.EditProfileVM
import com.andhikaihsansapplication.app.modules.listtodetail.ui.ListToDetailActivity
import com.andhikaihsansapplication.app.modules.mainpage.ui.MainPageActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class EditProfileActivity : BaseActivity<ActivityEditProfileBinding>(R.layout.activity_edit_profile)
    {
  private val viewModel: EditProfileVM by viewModels<EditProfileVM>()

  private val REQUEST_CODE_LIST_TO_DETAIL_ACTIVITY: Int = 181


  private val REQUEST_CODE_MAIN_PAGE_ACTIVITY: Int = 485


  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.editProfileVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.etFullname.setOnClickListener {
      val destIntent = ChangeNameActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.frameProfpic.setOnClickListener {
      ImagePickerFragmentDialog().show(supportFragmentManager)
      { path ->//TODO HANDLE DATA
      }

    }
    binding.etPhone.setOnClickListener {
      val destIntent = ChangePhoneNumberActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageSettings.setOnClickListener {
      val destIntent = ListToDetailActivity.getIntent(this, null)
      startActivityForResult(destIntent, REQUEST_CODE_LIST_TO_DETAIL_ACTIVITY)
    }
    binding.imageHome.setOnClickListener {
      val destIntent = MainPageActivity.getIntent(this, null)
      startActivityForResult(destIntent, REQUEST_CODE_MAIN_PAGE_ACTIVITY)
    }
    binding.btnArrowleft.setOnClickListener {
      finish()
    }
    binding.etAddress.setOnClickListener {
      val destIntent = ChangeAddressActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "EDIT_PROFILE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, EditProfileActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
