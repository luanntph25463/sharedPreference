package com.example.sharedpreference

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext

class MainActivity : AppCompatActivity() {
    private lateinit var userManager: UserManager

    companion object {
        private const val EDIT_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create an instance of UserManager
        userManager = UserManager(applicationContext)

        // Retrieve user information
        val username = userManager.getUser()
        val age = userManager.getAge()

        // Open the edit screen
        if (age != null) {
            openEditScreen(username, age.toInt())
        }
    }

    private fun openEditScreen(username: String?, age: Int) {
        val intent = Intent(this, Detail::class.java)
        intent.putExtra("Username", username)
        intent.putExtra("Age", age)

        startActivityForResult(intent, EDIT_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == EDIT_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // Retrieve the updated user information from the edit screen
            val updatedUsername = data?.getStringExtra("UpdatedUsername")
            val updatedAge = data?.getIntExtra("UpdatedAge", 0)

            // check null if the user is not null updated userName
            updatedUsername?.let {
                userManager.saveUser(updatedUsername)
            }

            // check null if the user is not null updated userAge
            updatedAge?.let {
                userManager.saveAge(it)
            }
        }
    }

}