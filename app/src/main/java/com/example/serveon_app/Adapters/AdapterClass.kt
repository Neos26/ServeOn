package com.example.serveon_app.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.serveon_app.DataClasses.dataClass
import com.example.serveon_app.R

class adapterClass (private val dataList: ArrayList<dataClass>) : RecyclerView.Adapter<adapterClass.ViewHolderClass>() {


    var onItemClick : ((dataClass) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.rvImage.setImageResource(currentItem.dataImage)
        holder.rvTitle.text = currentItem.dataTitle
        holder.rvBackground.setImageResource(currentItem.backGroundImage)

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(currentItem)
        }
    }

    class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rvBackground: ImageView = itemView.findViewById(R.id.background_img)
        val rvImage:ImageView = itemView.findViewById(R.id.pic)
        val rvTitle: TextView = itemView.findViewById(R.id.service_title)

    }
}