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

class userUpload : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var button: FloatingActionButton
    lateinit var db: DBHelper
    private lateinit var newArry: ArrayList<dataList>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_upload)

        recyclerView = findViewById(R.id.recyclerUpload)
        button = findViewById(R.id.floatingActionButton)

        button.setOnClickListener{
            intent = Intent(this, userUpload2::class.java)
            startActivity(intent)

        }

        db = DBHelper(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        displayuser()

    }

    private fun displayuser() {
        var newCursor: Cursor? = db!!.gettext()
        newArry = ArrayList<dataList>()
        while (newCursor!!.moveToNext()) {
            val uname = newCursor.getString(0)
            val uinformation = newCursor.getString(1)
            newArry.add(dataList(uname, uinformation))
        }
        recyclerView.adapter = myAdapter(newArry)
    }
}