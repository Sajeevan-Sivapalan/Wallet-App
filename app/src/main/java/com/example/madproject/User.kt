package com.example.madproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.View
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class User : AppCompatActivity() {
    lateinit var databaseRef: DatabaseReference

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

    fun deleteCurrentUser(view: View) {
        val userName = "hello1"
        databaseRef = FirebaseDatabase.getInstance().getReference("Users")
        databaseRef.child(userName).removeValue().addOnSuccessListener {
            var intent = Intent(this, Login::class.java)
            startActivity(intent)
            Toast.makeText(this, "Your account successfully deleted", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}