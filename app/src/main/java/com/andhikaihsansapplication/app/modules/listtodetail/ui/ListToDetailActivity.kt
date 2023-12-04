package com.andhikaihsansapplication.app.modules.listtodetail.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlin.Int
import kotlin.String
import kotlin.Unit

class ListToDetailActivity :
    BaseActivity<ActivityListToDetailBinding>(R.layout.activity_list_to_detail) {
  private val viewModel: ListToDetailVM by viewModels<ListToDetailVM>()

  private val REQUEST_CODE_MAIN_PAGE_ACTIVITY: Int = 332


  private val REQUEST_CODE_EDIT_PROFILE_ACTIVITY: Int = 224

  override fun onResume() {
    super.onResume()

    val fullNameText = findViewById<TextView>(R.id.txtVerizcaMaudia)
    val phoneNumber = findViewById<TextView>(R.id.txt62858123456)
    val email = findViewById<TextView>(R.id.txtEmail)

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
          usersRef.child(userSnapshot.key.toString()).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshotUser: DataSnapshot) {
              val snapshotValue = snapshotUser.getValue() // Mengambil nilai dari snapshot
              val map: Map<String, Any>? = snapshotValue as? Map<String, Any>

              fullNameText.text = map?.get("fullName").toString()
              phoneNumber.text = map?.get("phoneNumber").toString()
              email.text = map?.get("email").toString()
            }
            override fun onCancelled(error: DatabaseError) {}
          })
        }
      }
      override fun onCancelled(error: DatabaseError) {}
    })
  }

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
