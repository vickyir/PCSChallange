package com.developer.pcsapi.response.itemTransaksi

import com.developer.pcsapi.response.transaksi.Transaksi

data class itemTransasksiResponsePost(
    val `data`: Data,
    val message: String,
    val success: Boolean
)
