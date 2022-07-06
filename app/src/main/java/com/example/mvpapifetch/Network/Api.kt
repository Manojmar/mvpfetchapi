package com.example.mvpapifetch.Network

import com.example.mvpapifetch.Model.User
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @POST("login1.php")
    fun login(@Body params: JsonObject): Call<User>

    @GET("select.php")
    fun imgcount():Call<User>

    companion object{
        var gson= GsonBuilder()
            .setLenient()
            .create()

        operator fun invoke():Api{
            return Retrofit.Builder()
                .baseUrl("https://macappstudiotraining.com/manickaraj/api/products/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(Api::class.java)
        }
    }
}