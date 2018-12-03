package com.example.marcdev.devandroid.retrofit

import com.example.marcdev.devandroid.model.HomeComment
import com.example.marcdev.devandroid.model.HomePost
import retrofit2.Call
import retrofit2.http.GET

interface RetroService {


    @GET("posts")

fun list(): Call<List<HomePost>>

    @GET("comments")
    fun listComments(): Call<List<HomeComment>>
}