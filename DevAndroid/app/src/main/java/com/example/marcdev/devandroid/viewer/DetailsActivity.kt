package com.example.marcdev.devandroid.viewer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.marcdev.devandroid.R
import kotlinx.android.synthetic.main.activity_post.*
import com.example.marcdev.devandroid.adapter.DetailAdapter
import com.example.marcdev.devandroid.adapter.PostsAdapter
import com.example.marcdev.devandroid.model.HomeComment
import com.example.marcdev.devandroid.retrofit.RetroComment
import retrofit2.Call
import retrofit2.Response

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)


        mtoolbar?.setTitle(intent.getStringExtra(PostsAdapter.myViewHolder.ID_TITLE))




        /*val navBar= intent.getStringExtra(PostsAdapter.myViewHolder.ID_TITLE)
        supportActionBar?.title= navBar*/
        val call= RetroComment(intent).commentService().listComments()
        call.enqueue(object : retrofit2.Callback<List<HomeComment>?> {

            override fun onResponse(
                call: Call<List<HomeComment>?>?,
                response: Response<List<HomeComment>?>?) {

                response?.body()?.let {
                    val comment: List<HomeComment> = it
                    configureList(comment)
                    }

                }
            override fun onFailure(call: Call<List<HomeComment>?>, t: Throwable) {

                println("não deu pra passar!!! onFailure error")
            }
        })
    }


            private fun configureList(comment: List<HomeComment>) {

                val recyclerView = recycler_post
                recyclerView.adapter = DetailAdapter(comment,this)

                /*val layoutManager = StaggeredGridLayoutManager(
                    1, StaggeredGridLayoutManager.VERTICAL
                )*/
                recyclerView.layoutManager = LinearLayoutManager(this)
                }

        }


