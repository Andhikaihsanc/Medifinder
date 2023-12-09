package com.andhikaihsansapplication.app.modules.forgotpassword.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivityForgotPasswordBinding
import com.andhikaihsansapplication.app.modules.credentials.ui.CredentialsActivity
import com.andhikaihsansapplication.app.modules.forgotpassword.`data`.viewmodel.ForgotPasswordVM
import com.andhikaihsansapplication.app.modules.login.ui.LoginActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import kotlin.String
import kotlin.Unit

class ForgotPasswordActivity :
    BaseActivity<ActivityForgotPasswordBinding>(R.layout.activity_forgot_password) {
  private val viewModel: ForgotPasswordVM by viewModels<ForgotPasswordVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.forgotPasswordVM = viewModel
  }

  override fun setUpClicks(): Unit {

    binding.txtSendlink.setOnClickListener {
      val emailInput = findViewById<EditText>(R.id.lineLineOne)
      val emailInputValue = emailInput.text.toString()

      Firebase.auth.sendPasswordResetEmail(emailInputValue)
        .addOnCompleteListener { task ->
          if (task.isSuccessful) {
            Toast.makeText(baseContext, "Email sent.", Toast.LENGTH_SHORT,).show()
            Toast.makeText(baseContext, "Login with your new password", Toast.LENGTH_SHORT,).show()
          }
        }

      val destIntent = LoginActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "FORGOT_PASSWORD_ACTIVITY"

    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ForgotPasswordActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }

}
