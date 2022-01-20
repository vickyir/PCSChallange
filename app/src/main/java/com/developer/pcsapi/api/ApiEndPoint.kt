package com.developer.pcsapi.api

import com.developer.pcsapi.response.itemTransaksi.itemTransasksiResponsePost
import com.developer.pcsapi.response.login.LoginResponse
import com.developer.pcsapi.response.produk.ProdukResponse
import com.developer.pcsapi.response.produk.ProdukResponsePost
import com.developer.pcsapi.response.transaksi.TransaksiResponse
import com.developer.pcsapi.response.transaksi.TransaksiResponsePost
import retrofit2.Call
import retrofit2.http.*

interface ApiEndPoint {
    @FormUrlEncoded
    @POST("login")

    fun login(
        @Field("email") email : String,
        @Field("password") password : String) : Call<LoginResponse>

    @GET("produk")
    fun getProduk(@Header("Authorization") token : String) : Call<ProdukResponse>

    @FormUrlEncoded
    @POST("produk")

    fun postProduk(
        @Header("Authorization") token : String,
        @Field("admin_id") admin_id : Int,
        @Field("product_name") nama : String,
        @Field("harga") harga : Int,
        @Field("stok") stok : Int
    ) : Call<ProdukResponsePost>

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "produk", hasBody = true)

    fun deleteProduk(
        @Header("Authorization") token : String,
        @Field("id") id : Int
    ) : Call<ProdukResponsePost>

    @FormUrlEncoded
    @HTTP(method = "PUT", path = "produk", hasBody = true)

    fun putProduk(
        @Header("Authorization") token : String,
        @Field("id") id : Int,
        @Field("admin_id") admin_id : Int,
        @Field("product_name") nama : String,
        @Field("harga") harga : Int,
        @Field("stok") stok : Int
    ) : Call<ProdukResponsePost>

    @FormUrlEncoded
    @POST("transaksi")

    fun postTransaksi(
            @Header("Authorization") token : String,
            @Field("admin_id") admin_id : Int,
            @Field("total") total : Int
    ) : Call<TransaksiResponsePost>

    @FormUrlEncoded
    @POST("itemTransaksi")

    fun postItemTransaksi(
            @Header("Authorization") token : String,
            @Field("transaksi_id") transaksi_id : Int,
            @Field("product_id") produk_id : Int,
            @Field("qty") qty : Int,
            @Field("harga_saat_transaksi") harga_saat_transaksi : Int

    ) : Call<itemTransasksiResponsePost>

    @GET("transaksi")
    fun getLaporan(@Header("Authorization") token : String) : Call<TransaksiResponse>
}