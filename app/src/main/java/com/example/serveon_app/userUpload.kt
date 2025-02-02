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

class userUpload : AppCompatActivity() {
    private lateinit var name: TextInputEditText
    private lateinit var info: TextInputEditText
    private lateinit var upload: Button
    private lateinit var db: DBhelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_upload)

        name = findViewById(R.id.textEdit)
        info = findViewById(R.id.textEdit2)
        upload = findViewById(R.id.button)
        db =  DBhelper(this)

        upload.setOnClickListener {
            val  name = name.text.toString()
            val info = info.text.toString()
            val savedata = db.saveuserdata(name, info)
            if(TextUtils.isEmpty(name) || TextUtils.isEmpty(info)){
                Toast.makeText(this, "Add Name and Service Information", Toast.LENGTH_SHORT).show()

            }else{
                if(savedata == true){
                    Toast.makeText(this, "Service Uploaded", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "service not uploaded", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }
}