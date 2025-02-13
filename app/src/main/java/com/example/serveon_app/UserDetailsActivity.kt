package com.example.serveon_app

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.serveon_app.Activity.MainActivity
import com.example.serveon_app.Activity.User_display
import com.example.serveon_app.Activity.userUpload
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class UserDetailsActivity : AppCompatActivity() {

    private lateinit var back_btn: ImageView
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var fab: FloatingActionButton
    private lateinit var bottomAppBar: BottomAppBar

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)


        back_btn = findViewById(R.id.back_btn)

        val nameTextView: TextView = findViewById(R.id.nameTextView)
        val infoTextView: TextView = findViewById(R.id.infoTextView)
        val serviceTextView: TextView = findViewById(R.id.serviceTextView)
        val contactTextView: TextView = findViewById(R.id.contactTextView)
        val ratingTextView: TextView = findViewById(R.id.ratingTextView)
        bottomNav = findViewById(R.id.bottomnav)
        fab = findViewById(R.id.fab)
        bottomAppBar = findViewById(R.id.bottomappbar)


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

        back_btn.setOnClickListener{
            val intent = Intent(this, User_display::class.java)
            startActivity(intent)
        }

        fab.setOnClickListener {
            val intent = Intent(this, userUpload::class.java)
            startActivity(intent)

        }

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                        startActivity(Intent(this, MainActivity::class.java))
                    true

                }
                R.id.nav_search -> {
                    startActivity(Intent(this, User_display::class.java))
                    true
                }
                else -> false
            }
        }



    }
}