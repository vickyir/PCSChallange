package com.developer.pcsapi.adapter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.developer.pcsapi.LoginActivity
import com.developer.pcsapi.R
import com.developer.pcsapi.api.BaseRetrofit
import com.developer.pcsapi.response.produk.Produk
import com.developer.pcsapi.response.produk.ProdukResponsePost
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProdukAdapter(val listProduk: List<Produk>):RecyclerView.Adapter<ProdukAdapter.ViewHolder>() {

    private val api by lazy { BaseRetrofit().endPoint }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_produk, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produk = listProduk[position]
        holder.txtNamaProduk.text = produk.product_name
        holder.txtHarga.text = produk.harga
        val token = LoginActivity.sessionManager.getString("TOKEN")
        holder.btnDelete.setOnClickListener {
//            Toast.makeText(holder.itemView.context,produk.product_name.toString(), Toast.LENGTH_LONG).show()
            api.deleteProduk(token.toString(), produk.id.toInt()).enqueue(object :
                Callback<ProdukResponsePost> {
                override fun onResponse(
                    call: Call<ProdukResponsePost>,
                    response: Response<ProdukResponsePost>
                ) {
                    Log.d("Data",response.toString())
                    Toast.makeText(holder.itemView.context,"Data di Hapus", Toast.LENGTH_LONG).show()

                    holder.itemView.findNavController().navigate(R.id.produkFragment)
                }

                override fun onFailure(call: Call<ProdukResponsePost>, t: Throwable) {
                    Log.e("Error",t.toString())
                }
            })
        }

        holder.btnEdit.setOnClickListener {
            //Toast.makeText(holder.itemView.context,produk.product_name, Toast.LENGTH_LONG).show()
            val bundle = Bundle()
            bundle.putParcelable("produk", produk)
            bundle.putString("status", "edit")
            holder.itemView.findNavController().navigate(R.id.produkFormFragment, bundle)
        }

    }

    override fun getItemCount(): Int {
        return listProduk.size
    }



    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val txtNamaProduk = itemView.findViewById<TextView>(R.id.txtNamaProduk)
        val txtHarga = itemView.findViewById<TextView>(R.id.txtHarga)
        val btnDelete = itemView.findViewById<ImageButton>(R.id.btnDelete)
        val btnEdit = itemView.findViewById<ImageButton>(R.id.btnEdit)

    }

}