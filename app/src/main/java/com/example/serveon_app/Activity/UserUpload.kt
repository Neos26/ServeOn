package com.example.serveon_app.Activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.serveon_app.DBhelper
import com.example.serveon_app.R
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText

class userUpload : AppCompatActivity() {
    private lateinit var name: TextInputEditText
    private lateinit var info: TextInputEditText
    private lateinit var service: TextInputEditText
    private lateinit var contact: TextInputEditText
    private lateinit var rating: TextInputEditText
    private lateinit var upload: Button
    private lateinit var db: DBhelper
    private lateinit var fab: FloatingActionButton
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var bottomAppBar: BottomAppBar

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_upload)

        name = findViewById(R.id.nameTextView)
        info = findViewById(R.id.infoTextView)
        service = findViewById(R.id.serviceTextView)
        contact = findViewById(R.id.contactTextView)
        rating = findViewById(R.id.ratingTextView)
        upload = findViewById(R.id.button)
        fab = findViewById(R.id.fab)
        bottomNav = findViewById(R.id.bottomnav)
        bottomAppBar = findViewById(R.id.bottomappbar)

        db =  DBhelper(this)

        upload.setOnClickListener {
            val  name = name.text.toString()
            val info = info.text.toString()
            val service = service.text.toString()
            val contact = contact.text.toString()
            val rating = rating.text.toString()
            val savedata = db.saveuserdata(name, info, service, contact, rating)
            if(TextUtils.isEmpty(name) || TextUtils.isEmpty(info) || TextUtils.isEmpty(service) || TextUtils.isEmpty(contact) || TextUtils.isEmpty(rating)){
                Toast.makeText(this, "Add Name and Service Information", Toast.LENGTH_SHORT).show()

            }else{
                if(savedata == true){
                    Toast.makeText(this, "Service Uploaded", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "service not uploaded", Toast.LENGTH_SHORT).show()
                }
            }

        }

        fab.setOnClickListener {
            if (this::class.java != userUpload::class.java) {
                val intent = Intent(this, userUpload::class.java)
                startActivity(intent)
            }

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