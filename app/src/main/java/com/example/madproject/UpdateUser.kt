package com.example.madproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.madproject.Validations.ValidationResult
import com.example.madproject.models.UserData

class UpdateUser : AppCompatActivity() {
    //lateinit var edtUpdUserName:EditText
    lateinit var edtUpdName:EditText
    lateinit var edtUpdPassword:EditText
    lateinit var edtUpdPassword2:EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_user)

        //edtUpdUserName = findViewById(R.id.edtUpdUserName)
        edtUpdName = findViewById(R.id.edtUpdName)
        edtUpdPassword = findViewById(R.id.edtUpdPassword)
        edtUpdPassword2 = findViewById(R.id.edtUpdPassword2)

    }

    fun UpdateUserAccount(view: View) {
        var count = 0

        val updateData = UserData(edtUpdName.text.toString(), edtUpdPassword.text.toString(), edtUpdPassword2.text.toString())
        val nameValidation = updateData.validateName()
        val passwordValidation = updateData.validatePassword()
        val rePasswordValidation = updateData.validateRePassword()

        when(nameValidation) {
            is ValidationResult.Valid -> {
                count++
            }
            is ValidationResult.Invalid -> {
                edtUpdName.error = nameValidation.errorMessage
            }
            is ValidationResult.Empty -> {
                edtUpdName.error = nameValidation.errorMessage
            }
        }

        when(passwordValidation) {
            is ValidationResult.Valid -> {
                count++
            }
            is ValidationResult.Invalid -> {
                edtUpdPassword.error = passwordValidation.errorMessage
            }
            is ValidationResult.Empty -> {
                edtUpdPassword.error = passwordValidation.errorMessage
            }
        }

        when(rePasswordValidation) {
            is ValidationResult.Valid -> {
                count++
            }
            is ValidationResult.Invalid -> {
                edtUpdPassword2.error = rePasswordValidation.errorMessage
            }
            is ValidationResult.Empty -> {
                edtUpdPassword2.error = rePasswordValidation.errorMessage
            }
        }

        if(count == 3){
            val intent = Intent(this, User::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun backToUser(view: View) {
        val intent = Intent(this, User::class.java)
        startActivity(intent)
        finish()
    }
}