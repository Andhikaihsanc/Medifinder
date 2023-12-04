package com.andhikaihsansapplication.app.modules.changeaddress.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivityChangeAddressBinding
import com.andhikaihsansapplication.app.modules.changeaddress.`data`.viewmodel.ChangeAddressVM
import com.andhikaihsansapplication.app.modules.editprofile.ui.EditProfileActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlin.String
import kotlin.Unit

class ChangeAddressActivity :
    BaseActivity<ActivityChangeAddressBinding>(R.layout.activity_change_address) {
  private val viewModel: ChangeAddressVM by viewModels<ChangeAddressVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.changeAddressVM = viewModel
  }

  override fun setUpClicks(): Unit {
    // firebase auth and current user
    var auth = FirebaseAuth.getInstance();
    var currentUserEmail = auth.currentUser?.email

    // firebase realtime
    var database = FirebaseDatabase.getInstance()
    var usersRef = database.getReference("users")
    var query = usersRef.orderByChild("email").equalTo(currentUserEmail.toString())

    binding.btnChangeAddress.setOnClickListener{
      val address = findViewById<EditText>(R.id.lineLineEleven)
      val addressValue = address.text.toString()

      // mencari username
      query.addListenerForSingleValueEvent(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
          for (userSnapshot in snapshot.children) {
            Toast.makeText(baseContext, userSnapshot.key.toString(), Toast.LENGTH_SHORT).show()
            usersRef.child(userSnapshot.key.toString()).child("address").setValue(addressValue)
          }
        }

        override fun onCancelled(error: DatabaseError) {}
      })

      val destIntent = EditProfileActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "CHANGE_ADDRESS_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ChangeAddressActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
