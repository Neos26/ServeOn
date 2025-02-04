package com.example.serveon_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.ImageView.ScaleType
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.graphics.blue
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.serveon_app.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var tutoringCard: ImageView
    private lateinit var deliveryCard: ImageView
    private lateinit var cateringCard: ImageView
    private lateinit var plumbingCard: ImageView
    private lateinit var SeeAll: TextView


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



        val imageSlider: ImageSlider = findViewById(R.id.imageSlider)
        val sliderModels = ArrayList<SlideModel>()
        sliderModels.add(SlideModel(R.drawable.camera_detail, ScaleTypes.FIT))
        sliderModels.add(SlideModel(R.drawable.image_detail, ScaleTypes.FIT))
        sliderModels.add(SlideModel(R.drawable.check_detail, ScaleTypes.FIT))

        imageSlider.setImageList(sliderModels, ScaleTypes.FIT)



    }

}