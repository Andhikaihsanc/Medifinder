package com.andhikaihsansapplication.app.modules.helpinformation.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivityHelpInformationBinding
import com.andhikaihsansapplication.app.modules.helpinformation.`data`.viewmodel.HelpInformationVM
import kotlin.Boolean
import kotlin.String
import kotlin.Unit

class HelpInformationActivity :
    BaseActivity<ActivityHelpInformationBinding>(R.layout.activity_help_information) {
  private val viewModel: HelpInformationVM by viewModels<HelpInformationVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.helpInformationVM = viewModel
    setUpSearchViewButtonCustomTListener()
  }

  override fun setUpClicks(): Unit {
    binding.btnArrowleft.setOnClickListener {
      finish()
    }
  }

  private fun setUpSearchViewButtonCustomTListener(): Unit {
    binding.searchViewButtonCustomT.setOnQueryTextListener(object :
    SearchView.OnQueryTextListener {
      override fun onQueryTextSubmit(p0 : String) : Boolean {
        // Performs search when user hit
        // the search button on the keyboard
        return false
      }
      override fun onQueryTextChange(p0 : String) : Boolean {
        // Start filtering the list as user
        // start entering the characters
        return false
      }
      })
    }

    companion object {
      const val TAG: String = "HELP_INFORMATION_ACTIVITY"


      fun getIntent(context: Context, bundle: Bundle?): Intent {
        val destIntent = Intent(context, HelpInformationActivity::class.java)
        destIntent.putExtra("bundle", bundle)
        return destIntent
      }
    }
  }
