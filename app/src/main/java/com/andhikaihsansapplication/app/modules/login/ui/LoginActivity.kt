package com.andhikaihsansapplication.app.modules.login.ui

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
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

  // firebase auth
  lateinit var auth: FirebaseAuth;

  // progress bar
  lateinit var progressBar: ProgressBar

  // firebase realtime
  var database = FirebaseDatabase.getInstance()
  var usersRef = database.getReference("users")


  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.loginVM = viewModel

    val Password = findViewById<EditText>(R.id.lineLineTwo)
    Password.setOnTouchListener { v, event ->
      val right = 2 // Index of the right drawable
      if (event.action == MotionEvent.ACTION_UP) {
        if (event.rawX >= (Password.right - Password.compoundDrawables[right].bounds.width())) {
          val isPasswordVisible = Password.inputType == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
          Password.inputType = if (isPasswordVisible) InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD else InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
          val drawableId = if (isPasswordVisible) R.drawable.baseline_visibility_off_24 else R.drawable.baseline_visibility_24
          Password.setCompoundDrawablesWithIntrinsicBounds(null, null, resources.getDrawable(drawableId), null)
          Password.setSelection(Password.length())
          return@setOnTouchListener true
        }
      }
      false
    }
  }


    @RequiresApi(Build.VERSION_CODES.N)
  override fun setUpClicks(): Unit {
    binding.txtResister.setOnClickListener {
      val destIntent = RegisterActivity.getIntent(this, null)
      startActivity(destIntent)
    }

    binding.txtLoginOne.setOnClickListener {
      // inisialisasi viewmodel
      var viewModelEmail = ViewModelProvider(this).get(EmailVM::class.java)

      // deklarasi firebase auth
      auth = FirebaseAuth.getInstance()

      // ambil value username
      val usernameInput = findViewById<EditText>(R.id.lineLineOne)
      val usernameInputValue = usernameInput.text.toString()

      // ambil value password
      val passwordInput = findViewById<EditText>((R.id.lineLineTwo))
      val passwordInputVaue = passwordInput.text.toString()

      progressBar = findViewById(R.id.progressBar)
      progressBar.visibility = View.VISIBLE

      // mengambil email di database dan update di view model
      usersRef.child(usernameInputValue).addValueEventListener(object :
        ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
          val map: Map<String, Any>? = snapshot.getValue() as? Map<String, Any>
          viewModelEmail.simpanData(map?.get("email").toString())
        }
        override fun onCancelled(error: DatabaseError) {
          Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
        }
      })

      // Mengamati perubahan data nama
      viewModelEmail.email.observe(this) { email ->
        if(email !== ""){
          auth.signInWithEmailAndPassword(email, passwordInputVaue)
            .addOnCompleteListener(this) { task ->
              if (task.isSuccessful) {
                progressBar.visibility = View.GONE
                // Sign in success, update UI with the signed-in user's information
                Toast.makeText(baseContext, "Login Success.", Toast.LENGTH_SHORT,).show()
                val destIntent = MainPageActivity.getIntent(this, null)
                startActivity(destIntent)
              } else {
                Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT,).show()
                progressBar.visibility = View.GONE
              }
            }
        }
      }
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
