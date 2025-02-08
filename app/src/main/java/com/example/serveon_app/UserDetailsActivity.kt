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
        val serviceTextView: TextView = findViewById(R.id.serviceTextView)
        val contactTextView: TextView = findViewById(R.id.contactTextView)
        val ratingTextView: TextView = findViewById(R.id.ratingTextView)


        val username = intent.getStringExtra("username")
        val userinfo = intent.getStringExtra("userinfo")
        val service = intent.getStringExtra("service")
        val contact = intent.getStringExtra("contact")
        val rating = intent.getStringExtra("rating")


        nameTextView.text = username
        infoTextView.text = userinfo
        serviceTextView.text = service
        contactTextView.text = contact
        ratingTextView.text = rating

    }
}