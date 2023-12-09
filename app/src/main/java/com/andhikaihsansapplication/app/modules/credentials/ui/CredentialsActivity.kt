package com.andhikaihsansapplication.app.modules.credentials.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.MotionEvent
import android.widget.EditText
import androidx.activity.viewModels
import com.andhikaihsansapplication.app.R
import com.andhikaihsansapplication.app.appcomponents.base.BaseActivity
import com.andhikaihsansapplication.app.databinding.ActivityCredentialsBinding
import com.andhikaihsansapplication.app.modules.credentials.`data`.viewmodel.CredentialsVM
import com.andhikaihsansapplication.app.modules.updated.ui.UpdatedActivity
import kotlin.String
import kotlin.Unit

class CredentialsActivity : BaseActivity<ActivityCredentialsBinding>(R.layout.activity_credentials)
    {
  private val viewModel: CredentialsVM by viewModels<CredentialsVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.credentialsVM = viewModel

    val newpassword = findViewById<EditText>(R.id.lineLineOne)
    newpassword.setOnTouchListener { v, event ->
      val right = 2 // Index of the right drawable
      if (event.action == MotionEvent.ACTION_UP) {
        if (event.rawX >= (newpassword.right - newpassword.compoundDrawables[right].bounds.width())) {
          val isPasswordVisible = newpassword.inputType == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
          newpassword.inputType = if (isPasswordVisible) InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD else InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
          val drawableId = if (isPasswordVisible) R.drawable.baseline_visibility_off_24 else R.drawable.baseline_visibility_24
          newpassword.setCompoundDrawablesWithIntrinsicBounds(null, null, resources.getDrawable(drawableId), null)
          newpassword.setSelection(newpassword.length())
          return@setOnTouchListener true
        }
      }
      false
    }

    val confirmpassword = findViewById<EditText>(R.id.lineLineOneOne)
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
    binding.btnUpdate.setOnClickListener {
      val destIntent = UpdatedActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "CREDENTIALS_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, CredentialsActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
