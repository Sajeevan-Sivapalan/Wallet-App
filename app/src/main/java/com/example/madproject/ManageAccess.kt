package com.example.madproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ManageAccess : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_access)
    }

    fun backToUser(view: View) {
        val intent = Intent(this, User::class.java)
        startActivity(intent)
        finish()
    }
}