package com.andhikaihsansapplication.app.modules.spesialisjantung.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivitySpesialisJantungBinding
import com.andhikaihsansapplication.app.modules.spesialisjantung.`data`.model.ListbrawijayauniveRowModel
import com.andhikaihsansapplication.app.modules.spesialisjantung.`data`.viewmodel.SpesialisJantungVM
import com.andhikaihsansapplication.app.modules.spesialisjantung.recyclerHandler.RumahSakit
import com.andhikaihsansapplication.app.modules.spesialisjantung.recyclerHandler.RumahSakitAdapter
import com.andhikaihsansapplication.app.modules.spesialisjantung.recyclerHandler.RumahSakitClickListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlin.Int
import kotlin.String
import kotlin.Unit

class SpesialisJantungActivity :
    BaseActivity<ActivitySpesialisJantungBinding>(R.layout.activity_spesialis_jantung), RumahSakitClickListener {
  private val viewModel: SpesialisJantungVM by viewModels<SpesialisJantungVM>()

  private lateinit var recyclerView: RecyclerView
  private lateinit var rumahSakitAdapter: RumahSakitAdapter

  override fun onResume() {
    super.onResume()

    val listHeaderText = findViewById<TextView>(R.id.listHeaderText)
    listHeaderText.text = intent.getStringExtra("CURRENT_KATEGORI")

    val rumahSakitList = listOf(
      RumahSakit("Rumah Sakit A", "Jl. A No. 1", "0813356188823"),
      RumahSakit("Rumah Sakit B", "Jl. B No. 2", "0813356188823"),
      RumahSakit("Rumah Sakit C", "Jl. C No. 3", "0813356188823")
    )

    recyclerView = findViewById(R.id.recyclerListbrawijayaunive)
    recyclerView.layoutManager = LinearLayoutManager(this)
    rumahSakitAdapter = RumahSakitAdapter(rumahSakitList, this)
    recyclerView.adapter = rumahSakitAdapter
  }

  override fun onRumahSakitClicked(rumahSakit: RumahSakit) {
    // Handle klik pada item rumah sakit di sini
    // Contoh: Tampilkan pesan Toast
    Toast.makeText(this, "Anda memilih ${rumahSakit.nama}", Toast.LENGTH_SHORT).show()
  }

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
