package com.example.serveon_app

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class userUpload2 : AppCompatActivity() {

    private lateinit var name : TextInputEditText
    private lateinit var information : TextInputEditText
    private lateinit var upload : Button
    private lateinit var db : DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_upload2)

        name = findViewById(R.id.textedit)
        information = findViewById(R.id.textedit2)
        upload = findViewById(R.id.button)
        db = DBHelper(this)

        upload.setOnClickListener{
            val name = name.text.toString()
            val information = information.text.toString()
            val savedata = db.saveuserdata(name, information)
            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(information)) {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()

            }
            else{
                if(savedata == true){
                    Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, "Data not saved", Toast.LENGTH_SHORT).show()
                }
            }
        }




    }
}