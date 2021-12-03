package com.developer.pcs

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(inflater: LayoutInflater, parent: ViewGroup): RecyclerView.ViewHolder(inflater.inflate(R.layout.recycler_view_template, parent, false)) {

    private var txtTitle: TextView? = null

    init {
        txtTitle = itemView.findViewById(R.id.title)
    }

    fun bind(data: Recycler){
        txtTitle?.text = data.txtTitle
    }
}