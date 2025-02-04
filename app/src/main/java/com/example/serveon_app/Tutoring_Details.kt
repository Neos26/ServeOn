package com.example.serveon_app


import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class Tutoring_Details : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var detailsDataList: ArrayList<detailsDataClass>
    private lateinit var imageList: Array<Int>
    private lateinit var titleList: Array<String>
    private lateinit var searchView: SearchView
    private lateinit var searchList: ArrayList<detailsDataClass>
    private lateinit var back_btn2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutoring)



        imageList = arrayOf(
            R.drawable.ic_list,
            R.drawable.ic_checkbox,
            R.drawable.ic_image,
            R.drawable.ic_toggle,
            R.drawable.ic_date,
            R.drawable.ic_rating,
            R.drawable.ic_time,
            R.drawable.ic_text,
            R.drawable.ic_edit)

        titleList = arrayOf(
            "Application Development\n * MR. Jerry Lucas\n * Masters in IT",
            "Information Management",
            "Data structures",
            "Introduction to Programming",
            "Introduction to Computing ",
            "Object Oriented Programming",
            "Discrete Structures",
            "Computer Organization",
            "Platform Technologies")


        recyclerView = findViewById(R.id.recyclerViewTutoring)
        searchView = findViewById(R.id.searchTutoring)
        back_btn2 = findViewById(R.id.back_btn)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        detailsDataList = arrayListOf()
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
                    detailsDataList.forEach{
                        if (it.dataTitle.lowercase(Locale.getDefault()).contains(searchText)){
                            searchList.add(it)
                        }
                    }
                    recyclerView.adapter!!.notifyDataSetChanged()
                }else{
                    searchList.clear()
                    searchList.addAll(detailsDataList)
                    recyclerView.adapter!!.notifyDataSetChanged()
                }
                return false
            }

        })

    }

        private fun getData() {
            for (i in imageList.indices) {
                if (i < titleList.size) {
                    val dataClass = detailsDataClass(imageList[i], titleList[i])
                    detailsDataList.add(dataClass)
                }
            }
            searchList.addAll(detailsDataList)
            recyclerView.adapter = detail_adapter(searchList)

            back_btn2.setOnClickListener{
                val intent = Intent(this, tutoring_Activity::class.java)
                startActivity(intent)
            }

        }
    }
