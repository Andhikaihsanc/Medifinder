package com.andhikaihsansapplication.app.modules.onboardingone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivityOnBoardingOneBinding
import com.andhikaihsansapplication.app.modules.onboardingone.`data`.model.ListsearchRowModel
import com.andhikaihsansapplication.app.modules.onboardingone.`data`.viewmodel.OnBoardingOneVM
import com.andhikaihsansapplication.app.modules.onboardingthree.ui.OnBoardingThreeActivity
import com.andhikaihsansapplication.app.modules.onboardingtwo.ui.OnBoardingTwoActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class OnBoardingOneActivity :
    BaseActivity<ActivityOnBoardingOneBinding>(R.layout.activity_on_boarding_one) {
  private val viewModel: OnBoardingOneVM by viewModels<OnBoardingOneVM>()

  private val REQUEST_CODE_ON_BOARDING_THREE_ACTIVITY: Int = 473

  private val REQUEST_CODE_ON_BOARDING_TWO_ACTIVITY: Int = 558

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listsearchAdapter = ListsearchAdapter(viewModel.listsearchList.value?:mutableListOf())
    binding.recyclerListsearch.adapter = listsearchAdapter
    listsearchAdapter.setOnItemClickListener(
    object : ListsearchAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ListsearchRowModel) {
        onClickRecyclerListsearch(view, position, item)
      }
    }
    )
    viewModel.listsearchList.observe(this) {
      listsearchAdapter.updateData(it)
    }
    binding.onBoardingOneVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnGetStarted.setOnClickListener {
      val destIntent = OnBoardingTwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.txtSkip.setOnClickListener {
      val destIntent = OnBoardingThreeActivity.getIntent(this, null)
      startActivityForResult(destIntent, REQUEST_CODE_ON_BOARDING_THREE_ACTIVITY)
    }
    binding.imageArrowright.setOnClickListener {
      val destIntent = OnBoardingTwoActivity.getIntent(this, null)
      startActivityForResult(destIntent, REQUEST_CODE_ON_BOARDING_TWO_ACTIVITY)
    }
  }

  fun onClickRecyclerListsearch(
    view: View,
    position: Int,
    item: ListsearchRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "ON_BOARDING_ONE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, OnBoardingOneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
