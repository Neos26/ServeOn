package com.example.serveon_app

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UserDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        val nameTextView: TextView = findViewById(R.id.nameTextView)
        val infoTextView: TextView = findViewById(R.id.infoTextView)

        val username = intent.getStringExtra("username")
        val userinfo = intent.getStringExtra("userinfo")

        nameTextView.text = username
        infoTextView.text = userinfo
    }
}