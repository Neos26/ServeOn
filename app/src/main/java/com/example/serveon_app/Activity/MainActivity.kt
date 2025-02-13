package com.example.serveon_app.Activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.serveon_app.ChildCare
import com.example.serveon_app.GraphicDesign
import com.example.serveon_app.Grooming
import com.example.serveon_app.HouseKeeping
import com.example.serveon_app.R
import com.example.serveon_app.databinding.ActivityMainBinding
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var tutoringCard: ImageView
    private lateinit var deliveryCard: ImageView
    private lateinit var cateringCard: ImageView
    private lateinit var plumbingCard: ImageView
    private lateinit var housekeepingBtn: ImageView
    private lateinit var childCareBtn: ImageView
    private lateinit var graphicBtn: ImageView
    private lateinit var groomerBtn: ImageView
    private lateinit var SeeAll: TextView
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var fab: FloatingActionButton
    private lateinit var bottomAppBar: BottomAppBar




    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tutoringCard = findViewById(R.id.tutoringSide)
        deliveryCard = findViewById(R.id.plumbingSide)
        cateringCard = findViewById(R.id.photographerSide)
        plumbingCard = findViewById(R.id.deliverySide)
        housekeepingBtn = findViewById(R.id.housekeepingbtn)
        childCareBtn = findViewById(R.id.childcarebtn)
        graphicBtn = findViewById(R.id.graphicbtn)
        groomerBtn = findViewById(R.id.groomerbtn)
        bottomNav = findViewById(R.id.bottomnav)
        fab = findViewById(R.id.fab)
        bottomAppBar = findViewById(R.id.bottomappbar)


        SeeAll = findViewById(R.id.seeAllTExt)



        tutoringCard.setOnClickListener{
            val intent = Intent(this, tutoring_Activity::class.java)
            startActivity(intent)
        }

        deliveryCard.setOnClickListener{
            val intent = Intent(this, Delivery_Activity::class.java)
            startActivity(intent)
        }

        cateringCard.setOnClickListener{
            val intent = Intent(this, Catering_Activity::class.java)
            startActivity(intent)
        }

        plumbingCard.setOnClickListener{
            val intent = Intent(this, Plumbing_Activity::class.java)
            startActivity(intent)
        }

        SeeAll.setOnClickListener{
            val intent = Intent(this, User_display::class.java)
            startActivity(intent)
        }

        housekeepingBtn.setOnClickListener{
            val intent = Intent(this, HouseKeeping::class.java)
            startActivity(intent)
        }

        childCareBtn.setOnClickListener{
            val intent = Intent(this, ChildCare::class.java)
            startActivity(intent)
        }

        graphicBtn.setOnClickListener{
            val intent = Intent(this, GraphicDesign::class.java)
            startActivity(intent)
        }

        groomerBtn.setOnClickListener{
            val intent = Intent(this, Grooming::class.java)
            startActivity(intent)
        }


        fab.setOnClickListener {
            val intent = Intent(this, userUpload::class.java)
            startActivity(intent)

        }

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    if (this::class.java != MainActivity::class.java) {
                        startActivity(Intent(this, MainActivity::class.java))
                    }
                    true

                }
                R.id.nav_search -> {
                    startActivity(Intent(this, User_display::class.java))
                    true
                }
                else -> false
            }
        }


        val imageSlider: ImageSlider = findViewById(R.id.imageSlider)
        val sliderModels = ArrayList<SlideModel>()
        sliderModels.add(SlideModel(R.drawable.slider1, ScaleTypes.FIT))
        sliderModels.add(SlideModel(R.drawable.slider2, ScaleTypes.FIT))
        sliderModels.add(SlideModel(R.drawable.slider3, ScaleTypes.FIT))

        imageSlider.setImageList(sliderModels, ScaleTypes.FIT)



    }

}