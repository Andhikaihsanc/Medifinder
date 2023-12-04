package com.andhikaihsansapplication.app.modules.deleteaccconfirmation.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivityDeleteAccConfirmationBinding
import com.andhikaihsansapplication.app.modules.deleteaccconfirmation.`data`.viewmodel.DeleteAccConfirmationVM
import com.andhikaihsansapplication.app.modules.splashscreen.ui.SplashScreenActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlin.String
import kotlin.Unit

class DeleteAccConfirmationActivity :
    BaseActivity<ActivityDeleteAccConfirmationBinding>(R.layout.activity_delete_acc_confirmation) {
  private val viewModel: DeleteAccConfirmationVM by viewModels<DeleteAccConfirmationVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.deleteAccConfirmationVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnNo.setOnClickListener {
      finish()
    }
    binding.btnYesImSure.setOnClickListener {
      val user = Firebase.auth.currentUser!!

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
            usersRef.child(userSnapshot.key.toString()).removeValue()
          }
        }
        override fun onCancelled(error: DatabaseError) {}
      })

      user.delete()
        .addOnCompleteListener { task ->
          if (task.isSuccessful) {
            Toast.makeText(baseContext, "Account deleted", Toast.LENGTH_SHORT).show()
          }
        }
      val destIntent = SplashScreenActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "DELETE_ACC_CONFIRMATION_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, DeleteAccConfirmationActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
