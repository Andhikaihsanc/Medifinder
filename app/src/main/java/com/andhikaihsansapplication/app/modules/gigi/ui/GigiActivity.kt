package com.andhikaihsansapplication.app.modules.gigi.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivityGigiBinding
import com.andhikaihsansapplication.app.modules.gigi.`data`.model.GigiRowModel
import com.andhikaihsansapplication.app.modules.gigi.`data`.viewmodel.GigiVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class GigiActivity : BaseActivity<ActivityGigiBinding>(R.layout.activity_gigi) {
  private val viewModel: GigiVM by viewModels<GigiVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val gigiAdapter = GigiAdapter(viewModel.gigiList.value?:mutableListOf())
    binding.recyclerGigi.adapter = gigiAdapter
    gigiAdapter.setOnItemClickListener(
    object : GigiAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : GigiRowModel) {
        onClickRecyclerGigi(view, position, item)
      }
    }
    )
    viewModel.gigiList.observe(this) {
      gigiAdapter.updateData(it)
    }
    binding.gigiVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerGigi(
    view: View,
    position: Int,
    item: GigiRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "GIGI_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, GigiActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
