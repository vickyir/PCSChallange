package com.developer.pcs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class List : AppCompatActivity() {
    lateinit var recylerView: RecyclerView
    lateinit var adapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        init()
        recylerView.layoutManager = LinearLayoutManager(this)
        recylerView.adapter = adapter
    }

    private fun init(){
        recylerView = findViewById(R.id.list)

        var data = ArrayList<Recycler>()
        data.add(Recycler("Vicky"))
        data.add(Recycler("Reyhan"))
        data.add(Recycler("Sindhy"))
        data.add(Recycler("Dinda"))
        data.add(Recycler("Abdi"))
        data.add(Recycler("Dico"))

        adapter = MyAdapter(data)
    }
}