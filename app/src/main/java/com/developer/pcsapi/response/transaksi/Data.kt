package com.developer.pcsapi.response.transaksi

data class Data(
    val transaksi: List<Transaksi>,
    val total: String
)