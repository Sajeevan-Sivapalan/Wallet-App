package com.example.madproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.madproject.Validations.ValidationResult
import com.example.madproject.models.UserData

class AddAdminAccess : AppCompatActivity() {
    lateinit var edtAccUserName:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_admin_access)

        edtAccUserName = findViewById(R.id.edtAccUserName)
    }

    fun AddAccess(view: View) {
        var count = 0

        val addAccessData = UserData(edtAccUserName.text.toString())
        val userNameValidation = addAccessData.validateUserName()

        when(userNameValidation) {
            is ValidationResult.Valid -> {
                count++
            }
            is ValidationResult.Empty -> {
                edtAccUserName.error = userNameValidation.errorMessage
            }
            is ValidationResult.Invalid -> {
                edtAccUserName.error = userNameValidation.errorMessage
            }
        }
        if(count == 1) {
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