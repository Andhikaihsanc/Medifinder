package com.andhikaihsansapplication.app.modules.register.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivityRegisterBinding
import com.andhikaihsansapplication.app.modules.login.ui.LoginActivity
import com.andhikaihsansapplication.app.modules.register.`data`.viewmodel.RegisterVM
import kotlin.String
import kotlin.Unit
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.andhikaihsansapplication.app.modules.register.data.User
import com.andhikaihsansapplication.app.modules.spesialisjantung.recyclerHandler.RumahSakit
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(R.layout.activity_register) {
  private val viewModel: RegisterVM by viewModels<RegisterVM>()

  // firebase auth
  lateinit var auth: FirebaseAuth;

  // progress bar
  lateinit var progressBar: ProgressBar

  // firebase realtime
  var database = FirebaseDatabase.getInstance()
  var usersRef = database.getReference("users")

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.registerVM = viewModel

    val password = findViewById<EditText>(R.id.lineLineFive)
    password.setOnTouchListener { v, event ->
      val right = 2 // Index of the right drawable
      if (event.action == MotionEvent.ACTION_UP) {
        if (event.rawX >= (password.right - password.compoundDrawables[right].bounds.width())) {
          val isPasswordVisible = password.inputType == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
          password.inputType = if (isPasswordVisible) InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD else InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
          val drawableId = if (isPasswordVisible) R.drawable.baseline_visibility_off_24 else R.drawable.baseline_visibility_24
          password.setCompoundDrawablesWithIntrinsicBounds(null, null, resources.getDrawable(drawableId), null)
          password.setSelection(password.length())
          return@setOnTouchListener true
        }
      }
      false
    }

    val confirmpassword = findViewById<EditText>(R.id.lineLineSix)
    confirmpassword.setOnTouchListener { v, event ->
      val right = 2 // Index of the right drawable
      if (event.action == MotionEvent.ACTION_UP) {
        if (event.rawX >= (confirmpassword.right - confirmpassword.compoundDrawables[right].bounds.width())) {
          val isPasswordVisible = confirmpassword.inputType == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
          confirmpassword.inputType = if (isPasswordVisible) InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD else InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
          val drawableId = if (isPasswordVisible) R.drawable.baseline_visibility_off_24 else R.drawable.baseline_visibility_24
          confirmpassword.setCompoundDrawablesWithIntrinsicBounds(null, null, resources.getDrawable(drawableId), null)
          confirmpassword.setSelection(confirmpassword.length())
          return@setOnTouchListener true
        }
      }
      false
    }
  }

  override fun setUpClicks(): Unit {
    // deklarasi firebase auth
    auth = FirebaseAuth.getInstance()

    binding.txtRegisterOne.setOnClickListener{
      // ambil value username
      val usernameInput = findViewById<EditText>(R.id.lineLineOne)
      val usernameInputValue = usernameInput.text.toString()

      // ambil value email
      val emailInput = findViewById<EditText>((R.id.lineLineTwo))
      val emailInputValue = emailInput.text.toString()

      // ambil value full name
      val fullnameInput = findViewById<EditText>((R.id.lineLineThree))
      val fullnameInputVaue = fullnameInput.text.toString()

      // ambil value phone number
      val phonenumberInput = findViewById<EditText>((R.id.lineLineFour))
      val phonenumberInputValue = phonenumberInput.text.toString()

      // ambil value password
      val passwordInput = findViewById<EditText>((R.id.lineLineFive))
      val passwordInputVaue = passwordInput.text.toString()

      // ambil value confirm password
      val confirmPassword = findViewById<EditText>((R.id.lineLineSix))
      val confirmpasswordInputValue = confirmPassword.text.toString()

      val userNameList = mutableListOf<String>() // Buat list baru

      CoroutineScope(Dispatchers.IO).launch{
        usersRef.addListenerForSingleValueEvent(object :
          ValueEventListener {
          override fun onDataChange(snapshot: DataSnapshot) {
            for (user in snapshot.children) {
              var namaUser = user.key.toString()
              userNameList.add(namaUser)
            }
          }
          override fun onCancelled(error: DatabaseError) {}
        })

        delay(1000) // Tambahkan delay jika dibutuhkan untuk menunggu pengambilan data selesai
        withContext(Dispatchers.Main) {
          if(usernameInputValue == "" || emailInputValue == "" || fullnameInputVaue == "" || phonenumberInputValue == "" || passwordInputVaue == ""){
            Toast.makeText(baseContext, "Data tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            return@withContext
          } else if (userNameList.contains(usernameInputValue)){
            Toast.makeText(baseContext, "Username sudah dipakai!", Toast.LENGTH_SHORT).show()
            return@withContext
          } else if (passwordInputVaue !== confirmpasswordInputValue) {
            Toast.makeText(baseContext, "Confirm password tidak sama dengan password!", Toast.LENGTH_SHORT).show()
            return@withContext
          } else {
            progressBar = findViewById(R.id.progressBar)
            progressBar.visibility = View.VISIBLE

            // auth signup
            auth.createUserWithEmailAndPassword(emailInputValue, passwordInputVaue)
              .addOnCompleteListener(this@RegisterActivity) { task ->
                if (task.isSuccessful) {
                  progressBar.visibility = View.GONE

                  // add user di realtime database
                  var userRef = usersRef.child(usernameInputValue)
                  var userData = User(emailInputValue, fullnameInputVaue, phonenumberInputValue, passwordInputVaue)
                  userRef.setValue(userData)

                  Toast.makeText(baseContext, "Account Created.", Toast.LENGTH_SHORT,).show()

                  val destIntent = LoginActivity.getIntent(this@RegisterActivity, null)
                  startActivity(destIntent)
                } else {
                  Toast.makeText(baseContext, "Authentication failed.", Toast.LENGTH_SHORT,).show()
                }
              }
          }
        }
      }
    }

    binding.txtLogin.setOnClickListener {
      val destIntent = LoginActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "REGISTER_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, RegisterActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}

