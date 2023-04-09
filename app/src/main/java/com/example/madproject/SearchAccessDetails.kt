package com.example.madproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.madproject.Validations.ValidationResult
import com.example.madproject.models.UserData

class SearchAccessDetails : AppCompatActivity() {
    lateinit var edtSrhUserName: EditText
    var userName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_access_details)
        edtSrhUserName = findViewById(R.id.edtSrhUserName)

        userName = intent.getStringExtra("userName").toString()
    }

    fun SearchUser(view: View) {
        var count = 0;

        val searchData = UserData(edtSrhUserName.text.toString())
        val userNameValidation = searchData.validateUserName()

        when(userNameValidation) {
            is ValidationResult.Valid -> {
                count++
            }
            is ValidationResult.Invalid -> {
                edtSrhUserName.error = userNameValidation.errorMessage
            }
            is ValidationResult.Empty -> {
                edtSrhUserName.error = userNameValidation.errorMessage
            }
        }

        if(count == 1) {
            val intent = Intent(this, User::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun backToHome(view: View) {
        val intent = Intent(this, User::class.java)
        intent.putExtra("userName", userName)
        startActivity(intent)
        finish()
    }
}