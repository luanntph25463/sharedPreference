package com.example.sharedpreference

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_detail.btnUpdate
import kotlinx.android.synthetic.main.activity_detail.editAge
import kotlinx.android.synthetic.main.activity_detail.editName

class Detail : AppCompatActivity() {
    private lateinit var etUsername: EditText
    private lateinit var etAge: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        etUsername = findViewById(R.id.editName)
        etAge = findViewById(R.id.editAge)

        val username = intent.getStringExtra("Username")
        val age = intent.getIntExtra("Age", 0)

        etUsername.setText(username)
        etAge.setText(age.toString())

        val btnSave = findViewById<Button>(R.id.btnUpdate)
        btnSave.setOnClickListener {
            val updatedUsername = etUsername.text.toString()
            val updatedAge = etAge.text.toString().toInt()

            val resultIntent = Intent()
            resultIntent.putExtra("UpdatedUsername", updatedUsername)
            resultIntent.putExtra("UpdatedAge", updatedAge)

            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}