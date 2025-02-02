package com.example.serveon_app
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
class DBhelper(context: Context): SQLiteOpenHelper(context, "userdata", null, 1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table Userdata (name TEXT primary key, information TEXT)")
    }
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("drop table if exists Userdata")
    }
    fun saveuserdata(name: String, information: String): Boolean {
        val p0 = this.writableDatabase
        val cv = ContentValues()
        cv.put("name", name)
        cv.put("information", information)
        val result = p0.insert("Userdata", null, cv)
        if (result == (-1).toLong()){
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