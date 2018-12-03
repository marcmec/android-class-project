package com.example.marcdev.devandroid.viewer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import com.example.marcdev.devandroid.R
import com.example.marcdev.devandroid.adapter.PostsAdapter
import com.example.marcdev.devandroid.model.HomePost
import com.example.marcdev.devandroid.model.ListPost
import com.example.marcdev.devandroid.retrofit.RetroInitialize
import kotlinx.android.synthetic.main.activity_post.*
import retrofit2.Call
import retrofit2.Response


class PostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        val call= RetroInitialize().postService().list()
        call.enqueue(object : retrofit2.Callback<List<HomePost>?>{
            override fun onResponse(call: Call<List<HomePost>?>?,
                                    response: Response<List<HomePost>?>?) {

                response?.body()?.let {
                    val post :List<HomePost> = it
                    configureList(post)
                }
            }

            override fun onFailure(call: Call<List<HomePost>?>, t: Throwable) {
                println("onFailure chamado com sucesso!!")
            }
        })
    }

    private fun configureList(post: List<HomePost>){

        val recyclerView= recycler_post
        recyclerView.adapter= PostsAdapter(ListPost(post),this)

        val layoutManager =StaggeredGridLayoutManager(
            1, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager= layoutManager
    }

}
