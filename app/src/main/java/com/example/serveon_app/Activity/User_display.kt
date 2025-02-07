package com.example.serveon_app.Activity

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.serveon_app.DBhelper
import com.example.serveon_app.R
import com.example.serveon_app.DataClasses.data_list
import com.example.serveon_app.Adapters.myAdapter
import com.example.serveon_app.UserDetailsActivity
import java.util.Locale

class User_display : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private lateinit var dataList: ArrayList<data_list>
    private lateinit var adapter: myAdapter
    private lateinit var db: DBhelper
    private lateinit var back_btn3: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_display)
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchTutoring)
        back_btn3 = findViewById(R.id.back_btn)

        dataList = arrayListOf()
        db = DBhelper(this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        displayuser() // Load initial data

        // Handle search functionality
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val searchText = newText?.lowercase(Locale.getDefault()) ?: ""
                val filteredList = if (searchText.isNotEmpty()) {
                    dataList.filter { it.info.lowercase(Locale.getDefault()).contains(searchText) ||
                            it.name.lowercase(Locale.getDefault()).contains(searchText) }
                } else {
                    dataList
                }

                adapter.updateList(filteredList) // Update adapter with filtered data
                return true
            }
        })

        // Handle back button click
        back_btn3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Handle item clicks
        adapter.onItemClick = { selectedUser ->
            val intent = Intent(this, UserDetailsActivity::class.java)
            intent.putExtra("username", selectedUser.name)
            intent.putExtra("userinfo", selectedUser.info)
            startActivity(intent)
        }
    }

    private fun displayuser() {
        val newCursor: Cursor? = db.gettext()
        dataList.clear()

        while (newCursor!!.moveToNext()) {
            val uname = newCursor.getString(0)
            val uinformation = newCursor.getString(1)
            dataList.add(data_list(uname, uinformation))
        }

        adapter = myAdapter(dataList) // Set up adapter with initial full list
        recyclerView.adapter = adapter
    }
}
