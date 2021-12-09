package com.developer.pcsapi.api

import com.developer.pcsapi.response.login.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiEndPoint {
    @FormUrlEncoded
    @POST("login")

    fun login(
        @Field("email") email : String,
        @Field("password") password : String) : Call<LoginResponse>


}