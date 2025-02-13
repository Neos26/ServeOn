package com.example.serveon_app

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
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

class Grooming : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var fab: FloatingActionButton
    private lateinit var bottomAppBar: BottomAppBar
    private lateinit var back_btn: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_grooming)

        bottomNav = findViewById(R.id.bottomnav)
        fab = findViewById(R.id.fab)
        bottomAppBar = findViewById(R.id.bottomappbar)
        back_btn = findViewById(R.id.back_btn)





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

        back_btn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}