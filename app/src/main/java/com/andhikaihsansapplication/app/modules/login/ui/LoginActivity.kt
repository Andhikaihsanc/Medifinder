package com.andhikaihsansapplication.app.modules.login.ui

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivityLoginBinding
import com.andhikaihsansapplication.app.modules.forgotpassword.ui.ForgotPasswordActivity
import com.andhikaihsansapplication.app.modules.login.data.viewmodel.EmailVM
import com.andhikaihsansapplication.app.modules.login.`data`.viewmodel.LoginVM
import com.andhikaihsansapplication.app.modules.mainpage.ui.MainPageActivity
import com.andhikaihsansapplication.app.modules.register.ui.RegisterActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlin.String
import kotlin.Unit

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {
  private val viewModel: LoginVM by viewModels<LoginVM>()

//  // firebase auth
//  lateinit var auth: FirebaseAuth;
//
//  // progress bar
//  lateinit var progressBar: ProgressBar
//
//  // firebase realtime
//  var database = FirebaseDatabase.getInstance()
//  var usersRef = database.getReference("users")
//
//  // viewmodel
//  var viewModelEmail = ViewModelProvider(this).get(EmailVM::class.java)

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.loginVM = viewModel
  }

  override fun setUpClicks(): Unit {
    // deklarasi firebase auth
//    auth = FirebaseAuth.getInstance()

    binding.txtResister.setOnClickListener {
      val destIntent = RegisterActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.txtLoginOne.setOnClickListener {
//      // ambil value username
//      val usernameInput = findViewById<EditText>(R.id.lineLineOne)
//      val usernameInputValue = usernameInput.text.toString()
//
//      // ambil value password
//      val passwordInput = findViewById<EditText>((R.id.lineLineTwo))
//      val passwordInputVaue = passwordInput.text.toString()
//
//      progressBar = findViewById(R.id.progressBar)
//      progressBar.visibility = View.VISIBLE
//
//      viewModelEmail.mutableString.observe(this, Observer {
//        // mengambil email di database
//        usersRef.child(usernameInputValue).addValueEventListener(object :
//          ValueEventListener {
//          override fun onDataChange(snapshot: DataSnapshot) {
//            val map: Map<String, Any>? = snapshot.getValue() as? Map<String, Any>
//            var userEmail = map?.get("email").toString()
//            viewModelEmail.updateValue(userEmail)
//          }
//          override fun onCancelled(error: DatabaseError) {
//            Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
//          }
//        })
//
//        // auth login
//        auth.signInWithEmailAndPassword(it, passwordInputVaue)
//          .addOnCompleteListener(this) { task ->
//            if (task.isSuccessful) {
//              progressBar.visibility = View.GONE
//              // Sign in success, update UI with the signed-in user's information
//              Toast.makeText(baseContext, "Login Success.", Toast.LENGTH_SHORT,).show()
//            } else {
//              Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT,).show()
//            }
//          }
//      })
      val destIntent = MainPageActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.txtForgottenYour.setOnClickListener{
      val destIntent = ForgotPasswordActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "LOGIN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, LoginActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
