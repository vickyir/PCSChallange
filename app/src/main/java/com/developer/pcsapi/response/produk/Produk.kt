package com.developer.pcsapi.response.produk

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Produk(
    val admin_id: String,
    val harga: String,
    val id: String,
    val product_name: String,
    val stok: String
) : Parcelable