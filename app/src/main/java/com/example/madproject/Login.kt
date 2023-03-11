package com.example.madproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.madproject.Validations.ValidationResult
import com.example.madproject.models.UserData

class Login : AppCompatActivity() {
    lateinit var edtUserName:EditText
    lateinit var edtPassword:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtUserName = findViewById(R.id.edtUserName)
        edtPassword = findViewById(R.id.edtPassword)
    }

    fun openRegisterPage(view: View) {
        val intent = Intent(this, RegisterUser::class.java)
        startActivity(intent)
        finish()
    }

    fun loginFunction(view:View) {
        /*val intent = Intent(this, User::class.java)
        startActivity(intent)
        finish()*/
        var count = 0
        val loginData = UserData(edtUserName.text.toString(), edtPassword.text.toString())
        val userNameValidation = loginData.validateUserName()
        val passwordValidation = loginData.validatePassword()

        when(userNameValidation) {
            is ValidationResult.Valid -> {
                count++
            }
            is ValidationResult.Invalid -> {
                edtUserName.error = userNameValidation.errorMessage
            }
            is ValidationResult.Empty -> {
                edtUserName.error = userNameValidation.errorMessage
            }
        }

        when(passwordValidation) {
            is ValidationResult.Valid ->{
                count++
            }
            is ValidationResult.Invalid ->{
                edtPassword.error = passwordValidation.errorMessage
            }
            is ValidationResult.Empty -> {
                edtPassword.error = passwordValidation.errorMessage
            }
        }

        if(count == 2) {
            val intent = Intent(this, User::class.java)
            startActivity(intent)
            finish()
        }
    }
}