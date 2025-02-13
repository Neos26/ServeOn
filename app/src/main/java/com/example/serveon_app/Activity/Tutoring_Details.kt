package com.example.serveon_app.Activity



import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.serveon_app.R
import com.example.serveon_app.DataClasses.dataClass
import com.example.serveon_app.databinding.ActivityMainBinding
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class Tutoring_Details : AppCompatActivity() {
    private lateinit var back_btn2: ImageView
    private lateinit var fab: FloatingActionButton
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var bottomAppBar: BottomAppBar



    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutoring_details)
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
