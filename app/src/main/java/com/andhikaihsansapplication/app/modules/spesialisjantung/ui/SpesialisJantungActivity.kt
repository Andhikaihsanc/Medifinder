package com.andhikaihsansapplication.app.modules.spesialisjantung.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivitySpesialisJantungBinding
import com.andhikaihsansapplication.app.modules.spesialisjantung.`data`.model.ListbrawijayauniveRowModel
import com.andhikaihsansapplication.app.modules.spesialisjantung.`data`.viewmodel.SpesialisJantungVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class SpesialisJantungActivity :
    BaseActivity<ActivitySpesialisJantungBinding>(R.layout.activity_spesialis_jantung) {
  private val viewModel: SpesialisJantungVM by viewModels<SpesialisJantungVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listbrawijayauniveAdapter =
    ListbrawijayauniveAdapter(viewModel.listbrawijayauniveList.value?:mutableListOf())
    binding.recyclerListbrawijayaunive.adapter = listbrawijayauniveAdapter
    listbrawijayauniveAdapter.setOnItemClickListener(
    object : ListbrawijayauniveAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ListbrawijayauniveRowModel) {
        onClickRecyclerListbrawijayaunive(view, position, item)
      }
    }
    )
    viewModel.listbrawijayauniveList.observe(this) {
      listbrawijayauniveAdapter.updateData(it)
    }
    binding.spesialisJantungVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerListbrawijayaunive(
    view: View,
    position: Int,
    item: ListbrawijayauniveRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "SPESIALIS_JANTUNG_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SpesialisJantungActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
