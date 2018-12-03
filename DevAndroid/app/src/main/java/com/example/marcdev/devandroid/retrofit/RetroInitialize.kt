package com.example.marcdev.devandroid.retrofit

import com.example.marcdev.devandroid.model.HomePost
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInitialize {


    private val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun postService(): RetroService = retrofit.create(RetroService::class.java)


}