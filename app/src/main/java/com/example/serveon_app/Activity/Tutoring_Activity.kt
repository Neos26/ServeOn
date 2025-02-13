package com.example.serveon_app.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.serveon_app.R
import com.example.serveon_app.Adapters.adapterClass
import com.example.serveon_app.DataClasses.dataClass
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.Locale

class tutoring_Activity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<dataClass>
    private lateinit var imageList: Array<Int>
    private lateinit var titleList: Array<String>
    private lateinit var descList: Array<String>
    private lateinit var nameList: Array<String>
    private lateinit var serviceList: Array<String>
    private lateinit var contactList: Array<String>
    private lateinit var ratingList: Array<String>
    private lateinit var detailImageList: Array<Int>
    private lateinit var myAdapter: adapterClass
    private lateinit var searchView: SearchView
    private lateinit var searchList: ArrayList<dataClass>
    private lateinit var backGroundList: Array<Int>
    private lateinit var back_btn: ImageView
    private lateinit var fab: FloatingActionButton
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var bottomAppBar: BottomAppBar

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutoring)



        imageList = arrayOf(
            R.drawable.appdev,
            R.drawable.infomanagement,
            R.drawable.datastructures,
            R.drawable.introprog,
            R.drawable.hardware,
            R.drawable.oop,
            R.drawable.discrete,
            R.drawable.comporg,
            R.drawable.plattech
        )

        titleList = arrayOf(
            "Application Development",
            "Information Management",
            "Data structures",
            "Introduction to Programming",
            "Hardware and Software ",
            "Object Oriented Programming",
            "Discrete Structures",
            "Computer Organization",
            "Platform Technologies")

        nameList = arrayOf(
            "Jerry Lucas",
            "Michael Johnson",
            "Sarah Thompson",
            "David Martinez",
            "Emily Robinson",
            "Christopher Adams",
            "Jessica Lewis",
            "Daniel Walker",
            "Olivia Harris")

        serviceList = arrayOf(
            "Tutoring",
            "Tutoring",
            "Tutoring",
            "Tutoring",
            "Tutoring",
            "Tutoring",
            "Tutoring",
            "Tutoring",
            "Tutoring")

        contactList = arrayOf(
            "jerry.lucas@gmail.com",
            "michael.johnson@gmail.com",
            "sarah.thompson@gmail.com",
            "david.martinez@gmail.com",
            "emily.robinson@gmail.com",
            "christopher.adams@gmail.com",
            "jessica.lewis@gmail.com",
            "daniel.walker@gmail.com",
            "olivia.harris@gmail.com"
        )

        ratingList = arrayOf(
            "300 pesos / 1hr",
            "350 pesos / 1hr",
            "400 pesos / 1hr",
            "450 pesos / 1hr",
            "500 pesos / 1hr",
            "550 pesos / 1hr",
            "600 pesos / 1hr",
            "650 pesos / 1hr",
            "700 pesos / 1hr")


        descList = arrayOf(
            getString(R.string.listview),
            getString(R.string.checkbox),
            getString(R.string.imageview),
            getString(R.string.toggle),
            getString(R.string.date),
            getString(R.string.rating),
            getString(R.string.textview),
            getString(R.string.edit),
            getString(R.string.camera))

        detailImageList = arrayOf(
            R.drawable.list_detail,
            R.drawable.check_detail,
            R.drawable.image_detail,
            R.drawable.toggle_detail,
            R.drawable.date_detail,
            R.drawable.rating_detail,
            R.drawable.text_detail,
            R.drawable.edit_detail,
            R.drawable.camera_detail
        )

        backGroundList = arrayOf(
            R.drawable.bg_1,
            R.drawable.bg_2,
            R.drawable.bg_3,
            R.drawable.bg_4,
            R.drawable.bg_5,
            R.drawable.bg_1,
            R.drawable.bg_2,
            R.drawable.bg_3,
            R.drawable.bg_4

        )

        recyclerView = findViewById(R.id.recyclerViewTutoring)
        searchView = findViewById(R.id.searchTutoring)
        back_btn = findViewById(R.id.back_btn)
        bottomNav = findViewById(R.id.bottomnav)
        fab = findViewById(R.id.fab)
        bottomAppBar = findViewById(R.id.bottomappbar)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)


        dataList = arrayListOf()
        searchList = arrayListOf()
        getData()

        searchView.clearFocus()
        searchView.setOnQueryTextListener(object  : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                searchList.clear()
                val searchText = newText!!.lowercase(Locale.getDefault())
                if (searchText.isNotEmpty()){
                    dataList.forEach{
                        if (it.dataTitle.lowercase(Locale.getDefault()).contains(searchText)){
                            searchList.add(it)
                        }
                    }
                    recyclerView.adapter!!.notifyDataSetChanged()
                }else{
                    searchList.clear()
                    searchList.addAll(dataList)
                    recyclerView.adapter!!.notifyDataSetChanged()
                }
                return false
            }

        })
        myAdapter = adapterClass(searchList)
        recyclerView.adapter = myAdapter

        myAdapter.onItemClick = {
            val intent = Intent(this, Tutoring_Details::class.java)
            intent.putExtra("android", it)
            startActivity(intent)
        }
    }

    private fun getData() {
        for (i in imageList.indices) {
            if (i < titleList.size) {
                val dataClass = dataClass(imageList[i], titleList[i], descList[i], nameList[i], contactList[i], serviceList[i],
                    ratingList[i], detailImageList[i], backGroundList[i])
                dataList.add(dataClass)
            }
        }
        searchList.addAll(dataList)
        recyclerView.adapter = adapterClass(searchList)


        back_btn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
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
