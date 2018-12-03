package com.example.marcdev.devandroid.retrofit

import android.content.Intent
import com.example.marcdev.devandroid.adapter.PostsAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroComment (val intent: Intent){


    val postId= intent.getIntExtra(PostsAdapter.myViewHolder.ID, -1)

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/posts/"+postId+"/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun commentService(): RetroService = retrofit.create(RetroService::class.java)


}