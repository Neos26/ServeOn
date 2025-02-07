package com.example.serveon_app.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.serveon_app.DataClasses.data_list
import com.example.serveon_app.R

class myAdapter(private var userList: List<data_list>) :
    RecyclerView.Adapter<myAdapter.MyViewHolder>() {

    var onItemClick: ((data_list) -> Unit)? = null // Callback for item clicks

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tname: TextView = itemView.findViewById(R.id.textView)
        val tinformation: TextView = itemView.findViewById(R.id.textView2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.tname.text = currentItem.name
        holder.tinformation.text = currentItem.info

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(currentItem) // Trigger click event
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun updateList(newList: List<data_list>) {
        userList = ArrayList(newList)
        notifyDataSetChanged()
    }
}
