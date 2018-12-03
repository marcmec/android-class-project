package com.example.marcdev.devandroid.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.marcdev.devandroid.viewer.DetailsActivity
import com.example.marcdev.devandroid.R
import com.example.marcdev.devandroid.model.HomePost
import com.example.marcdev.devandroid.model.ListPost
import kotlinx.android.synthetic.main.row_post.view.*

class PostsAdapter (val homePost: ListPost,
                    private val context: Context) : RecyclerView.Adapter<PostsAdapter.myViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, position: Int): myViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.row_post,parent,false)

        return  myViewHolder(view)

    }

    override fun getItemCount(): Int {

        return homePost.posts.count()
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

        val postList= homePost.posts.get(position)
        holder?.itemView?.txt_title?.text= postList.title
        holder?.itemView?.txt_body?.text=postList.body

        holder?.posts= postList
        holder?.title=postList
    }

    class myViewHolder(itemView: View, var posts: HomePost?=null, var title: HomePost?=null) : RecyclerView.ViewHolder(itemView){


        companion object {
            val ID_TITLE= "title"
            val ID="id"

        }

        init {

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailsActivity::class.java)

                intent.putExtra(ID, posts?.id)
                intent.putExtra(ID_TITLE, title?.title)

                itemView.context.startActivity(intent)
            }
        }
    }
}