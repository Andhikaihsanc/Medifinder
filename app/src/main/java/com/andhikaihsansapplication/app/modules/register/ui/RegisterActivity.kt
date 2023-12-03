package com.andhikaihsansapplication.app.modules.register.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivityRegisterBinding
import com.andhikaihsansapplication.app.modules.login.ui.LoginActivity
import com.andhikaihsansapplication.app.modules.register.`data`.viewmodel.RegisterVM
import kotlin.String
import kotlin.Unit

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(R.layout.activity_register) {
  private val viewModel: RegisterVM by viewModels<RegisterVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.registerVM = viewModel
  }

  override fun setUpClicks(): Unit {
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

      Toast.makeText(this, "username = $usernameInputValue", Toast.LENGTH_SHORT).show()
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
