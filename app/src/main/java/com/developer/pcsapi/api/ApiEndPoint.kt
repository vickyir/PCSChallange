package com.developer.pcsapi.api

import com.developer.pcsapi.response.login.LoginResponse
import com.developer.pcsapi.response.produk.ProdukResponse
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


}