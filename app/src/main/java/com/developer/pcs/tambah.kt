package com.developer.pcs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class tambah : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah)
    }

    fun tambah(view: View){
        val angka1 = findViewById<EditText>(R.id.angka1)
        val angka2 = findViewById<EditText>(R.id.angka2)
        val hasil = findViewById<TextView>(R.id.hasil)

        val jumlah = angka1.text.toString().toDouble() + angka2.text.toString().toDouble()
        hasil.text = jumlah.toString()
    }
}