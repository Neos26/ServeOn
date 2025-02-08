package com.example.serveon_app
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBhelper(context: Context): SQLiteOpenHelper(context, "Userdata", null, 1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table Userdata (name TEXT primary key, information TEXT, service TEXT, contact TEXT, rating TEXT)")
    }
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("drop table if exists Userdata")
    }
    fun saveuserdata(name: String, information: String, service: String, contact: String, rating: String): Boolean {
        val p0 = this.writableDatabase
        val cv = ContentValues()
        cv.put("name", name)
        cv.put("information", information)
        cv.put("service", service)
        cv.put("contact", contact)
        cv.put("rating", rating)
        val result = p0.insert("Userdata", null, cv)
        if (result==-1.toLong()){
            return false
        }
        return true
    }
    fun gettext(): Cursor? {
        val p0 = this.readableDatabase
        val cursor = p0.rawQuery("select * from Userdata", null)
        return cursor

    }
}