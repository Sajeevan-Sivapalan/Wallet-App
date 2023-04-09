package com.example.madproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.madproject.Validations.ValidationResult
import com.example.madproject.models.UserData
import com.example.madproject.models.UserModel
import com.google.firebase.database.FirebaseDatabase

class AddAdminAccess : AppCompatActivity() {
    lateinit var edtAccUserName:EditText
    var userName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_admin_access)

        edtAccUserName = findViewById(R.id.edtAccUserName)

        userName = intent.getStringExtra("userName").toString()
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
            intent.putExtra("userName", userName)
            startActivity(intent)
            finish()
        }
    }

    fun backToUser(view: View) {
        val intent = Intent(this, User::class.java)
        intent.putExtra("userName", userName)
        startActivity(intent)
        finish()
    }
}