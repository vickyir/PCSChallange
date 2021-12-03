package com.developer.pcs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnIntent : Button
    lateinit var btnList: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIntent = findViewById(R.id.tambah)
        btnList = findViewById(R.id.list)
        btnIntent.setOnClickListener {
            val intent = Intent(this, tambah::class.java )
            startActivity(intent)
        }

        btnList.setOnClickListener {
            val intent2 = Intent(this, List::class.java)
            startActivity(intent2)
        }
    }


}