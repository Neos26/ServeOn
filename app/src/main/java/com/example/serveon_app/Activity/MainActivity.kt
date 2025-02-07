package com.example.serveon_app.Activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.serveon_app.R
import com.example.serveon_app.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var tutoringCard: ImageView
    private lateinit var deliveryCard: ImageView
    private lateinit var cateringCard: ImageView
    private lateinit var plumbingCard: ImageView
    private lateinit var SeeAll: TextView
    private lateinit var homeIcon: ImageView
    private lateinit var uploadIcon: ImageView




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
        homeIcon = findViewById(R.id.homeIcon)
        uploadIcon = findViewById(R.id.walletIcon)
        SeeAll = findViewById(R.id.seeAllTExt)



        tutoringCard.setOnClickListener{
            val intent = Intent(this, tutoring_Activity::class.java)
            startActivity(intent)
        }

        deliveryCard.setOnClickListener{
            val intent = Intent(this, delivery_Activity::class.java)
            startActivity(intent)
        }

        cateringCard.setOnClickListener{
            val intent = Intent(this, catering_Activity::class.java)
            startActivity(intent)
        }

        plumbingCard.setOnClickListener{
            val intent = Intent(this, plumbing_Activity::class.java)
            startActivity(intent)
        }

        SeeAll.setOnClickListener{
            val intent = Intent(this, User_display::class.java)
            startActivity(intent)
        }

        homeIcon.setOnClickListener {
            if (this::class.java != MainActivity::class.java) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        uploadIcon.setOnClickListener{
            val intent = Intent(this, userUpload::class.java)
            startActivity(intent)
        }



        val imageSlider: ImageSlider = findViewById(R.id.imageSlider)
        val sliderModels = ArrayList<SlideModel>()
        sliderModels.add(SlideModel(R.drawable.camera_detail, ScaleTypes.FIT))
        sliderModels.add(SlideModel(R.drawable.image_detail, ScaleTypes.FIT))
        sliderModels.add(SlideModel(R.drawable.check_detail, ScaleTypes.FIT))

        imageSlider.setImageList(sliderModels, ScaleTypes.FIT)



    }

}