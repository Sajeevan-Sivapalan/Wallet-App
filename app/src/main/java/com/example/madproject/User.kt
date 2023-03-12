package com.example.madproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class User : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
    }

    fun openAddAccess(view: View) {
        val intent = Intent(this, AddAdminAccess::class.java)
        startActivity(intent)
        finish()
    }

    fun openViewUser(view: View) {
        val intent = Intent(this, ViewUser::class.java)
        startActivity(intent)
        finish()
    }

    fun openUpdateUser(view: View) {
        val intent = Intent(this, UpdateUser::class.java)
        startActivity(intent)
        finish()
    }

    fun openManageAccess(view: View) {
        val intent = Intent(this, ManageAccess::class.java)
        startActivity(intent)
        finish()
    }

    fun openSearchUser(view: View) {
        val intent = Intent(this, SearchAccessDetails::class.java)
        startActivity(intent)
        finish()
    }
}