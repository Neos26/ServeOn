package com.example.serveon_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.serveon_app.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var tutoringCard: CardView
    private lateinit var deliveryCard: CardView
    private lateinit var cateringCard: CardView
    private lateinit var plumbingCard: CardView
    private lateinit var landscapingCard: CardView
    private lateinit var electricianCard: CardView
    private lateinit var barberCard: CardView
    private lateinit var photographerCard: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        tutoringCard = findViewById(R.id.tutoringCard)
        deliveryCard = findViewById(R.id.DeliveryCard)
        cateringCard = findViewById(R.id.cateringCard)
        plumbingCard = findViewById(R.id.plumbingCard)
        landscapingCard = findViewById(R.id.landscapingCard)
        electricianCard = findViewById(R.id.electricianCard)
        barberCard = findViewById(R.id.barberCard)
        photographerCard = findViewById(R.id.photographerCard)


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

        landscapingCard.setOnClickListener{
            val intent = Intent(this, landscaping_Activity::class.java)
            startActivity(intent)
        }

        electricianCard.setOnClickListener{
            val intent = Intent(this, electrician_Activity::class.java)
            startActivity(intent)
        }

        barberCard.setOnClickListener{
            val intent = Intent(this, barber_Activity::class.java)
            startActivity(intent)
        }

        photographerCard.setOnClickListener{
            val intent = Intent(this, photographer_Activity::class.java)
            startActivity(intent)
        }



    }

}