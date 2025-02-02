package com.example.serveon_app

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class User_display : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var floatingActionButton: FloatingActionButton
    lateinit var db: DBhelper
    private lateinit var newArry: ArrayList<data_list>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_display)

        recyclerView = findViewById(R.id.recyclerView)
        floatingActionButton = findViewById(R.id.floatingActionButton)


        floatingActionButton.setOnClickListener{
                intent = Intent(this, userUpload::class.java)
                startActivity(intent)
            }

            db = DBhelper(this)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.setHasFixedSize(true)
            displayuser()
        }
        private fun displayuser() {
            var newCursor: Cursor? = db!!.gettext()
            newArry = ArrayList<data_list>()
            while (newCursor!!.moveToNext()) {
                val uname = newCursor.getString(0)
                val uinformation = newCursor.getString(1)
                newArry.add(data_list(uname, uinformation))
            }
            recyclerView.adapter = myAdapter(newArry)
        }
    }