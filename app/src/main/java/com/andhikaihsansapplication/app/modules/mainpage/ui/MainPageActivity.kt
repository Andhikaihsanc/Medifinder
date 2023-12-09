package com.andhikaihsansapplication.app.modules.mainpage.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivityMainPageBinding
import com.andhikaihsansapplication.app.modules.editprofile.ui.EditProfileActivity
import com.andhikaihsansapplication.app.modules.gigi.ui.GigiActivity
import com.andhikaihsansapplication.app.modules.listtodetail.ui.ListToDetailActivity
import com.andhikaihsansapplication.app.modules.mainpage.`data`.model.MainPageRowModel
import com.andhikaihsansapplication.app.modules.mainpage.`data`.viewmodel.MainPageVM
import com.andhikaihsansapplication.app.modules.spesialisjantung.ui.SpesialisJantungActivity
import com.andhikaihsansapplication.app.modules.swipekanantwo.ui.SwipeKananTwoActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlin.Int
import kotlin.String
import kotlin.Unit

class MainPageActivity : BaseActivity<ActivityMainPageBinding>(R.layout.activity_main_page){

  private val viewModel: MainPageVM by viewModels<MainPageVM>(

  )

  private val REQUEST_CODE_LIST_TO_DETAIL_ACTIVITY: Int = 362


  private val REQUEST_CODE_SWIPE_KANAN_TWO_ACTIVITY: Int = 867


  private val REQUEST_CODE_EDIT_PROFILE_ACTIVITY: Int = 406


  private val REQUEST_CODE_GIGI_ACTIVITY: Int = 274


  private val REQUEST_CODE_SPESIALIS_JANTUNG_ACTIVITY: Int = 216

  override fun onResume() {
    super.onResume()

    val headerText = findViewById<TextView>(R.id.txtWelcomeVerizc)

    // firebase auth and current user
    var auth = FirebaseAuth.getInstance();
    var currentUserEmail = auth.currentUser?.email

    // firebase realtime
    var database = FirebaseDatabase.getInstance()
    var usersRef = database.getReference("users")
    var query = usersRef.orderByChild("email").equalTo(currentUserEmail.toString())

    // mencari username
    query.addListenerForSingleValueEvent(object : ValueEventListener {
      override fun onDataChange(snapshot: DataSnapshot) {
        for (userSnapshot in snapshot.children) {
          headerText.text = " Welcome, ${userSnapshot.key.toString()}"
        }
      }

      override fun onCancelled(error: DatabaseError) {}
    })
  }

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("")
    val mainPageAdapter = MainPageAdapter(viewModel.mainPageList.value?:mutableListOf())
    binding.recyclerMainPage.adapter = mainPageAdapter
    mainPageAdapter.setOnItemClickListener(
      object : MainPageAdapter.OnItemClickListener {
        override fun onItemClick(view:View, position:Int, item : MainPageRowModel) {
          onClickRecyclerMainPage(view, position, item)
        }
      }
    )
    viewModel.mainPageList.observe(this) {
      mainPageAdapter.updateData(it)
    }
    binding.mainPageVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageSettings.setOnClickListener {
      val destIntent = ListToDetailActivity.getIntent(this, null)
      startActivityForResult(destIntent, REQUEST_CODE_LIST_TO_DETAIL_ACTIVITY)
    }
    binding.btnEmergencyalert.setOnClickListener {
      val destIntent = SwipeKananTwoActivity.getIntent(this, null)
      startActivityForResult(destIntent, REQUEST_CODE_SWIPE_KANAN_TWO_ACTIVITY)
    }
    binding.imageUserTwo.setOnClickListener {
      val destIntent = EditProfileActivity.getIntent(this, null)
      startActivityForResult(destIntent, REQUEST_CODE_EDIT_PROFILE_ACTIVITY)
    }
    binding.btnEmergencyalert.setOnClickListener{
      val destIntent = SpesialisJantungActivity.getIntent(this, null)
      destIntent.putExtra("CURRENT_KATEGORI", "Find Hospital")
      startActivityForResult(destIntent, REQUEST_CODE_EDIT_PROFILE_ACTIVITY)
    }
  }

  fun onClickRecyclerMainPage(
    view: View,
    position: Int,
    item: MainPageRowModel
  ): Unit {
    when(view.id) {
      R.id.btnTelevision -> {
        val destIntent = GigiActivity.getIntent(this, null)
        startActivityForResult(destIntent, REQUEST_CODE_GIGI_ACTIVITY)
      }
      R.id.btnAirplane -> {
        val destIntent = SpesialisJantungActivity.getIntent(this, null)
        startActivityForResult(destIntent, REQUEST_CODE_SPESIALIS_JANTUNG_ACTIVITY)
      }
    }
  }

  companion object {
    const val TAG: String = "MAIN_PAGE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, MainPageActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
