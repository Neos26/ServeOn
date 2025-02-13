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
import com.example.serveon_app.Activity.tutoring_Activity
import com.example.serveon_app.Activity.userUpload
import com.example.serveon_app.DataClasses.dataClass
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DeliveryDetails : AppCompatActivity() {
    private lateinit var back_btn2: ImageView
    private lateinit var fab: FloatingActionButton
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var bottomAppBar: BottomAppBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_delivery_details)


        back_btn2 = findViewById(R.id.back_btn)
        fab = findViewById(R.id.fab)
        bottomNav = findViewById(R.id.bottomnav)
        bottomAppBar = findViewById(R.id.bottomappbar)



        val getData = intent.getParcelableExtra<dataClass>("android")
        if (getData != null) {
            val detailTitle: TextView = findViewById(R.id.detailTitle)
            val name: TextView = findViewById(R.id.name)
            val service: TextView = findViewById(R.id.service)
            val contactInfo: TextView = findViewById(R.id.contactInfo)
            val rating: TextView = findViewById(R.id.rating)

            val detailImage: ImageView = findViewById(R.id.detailImage)

            detailTitle.text = getData.dataTitle
            name.text = getData.namelist
            service.text = getData.servicelist
            contactInfo.text = getData.contactlist
            rating.text = getData.ratinglist

            detailImage.setImageResource(getData.dataDetailImage)
        }

        back_btn2.setOnClickListener{
            val intent = Intent(this, tutoring_Activity::class.java)
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