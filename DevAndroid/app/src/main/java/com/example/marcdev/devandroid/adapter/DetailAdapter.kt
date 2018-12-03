package com.example.marcdev.devandroid.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.marcdev.devandroid.viewer.DetailsActivity
import com.example.marcdev.devandroid.R
import com.example.marcdev.devandroid.model.HomeComment
import kotlinx.android.synthetic.main.row_coment.view.*

class DetailAdapter(
    val listaDetalhes: List<HomeComment>,
    val context: DetailsActivity
): RecyclerView.Adapter<DetailAdapter.myViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, position: Int): myViewHolder {

        val chama= LayoutInflater.from(context).inflate(R.layout.row_coment, parent, false)
        return myViewHolder(chama)

    }

    override fun getItemCount(): Int {

        return listaDetalhes.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val comment= listaDetalhes[position]

        holder?.let {
            it.bindView(comment)
        }

    }

     class myViewHolder( itemView: View) : RecyclerView.ViewHolder(itemView) {
         fun bindView(comment: HomeComment) {
             val name = itemView.txt_name
             val email = itemView.txt_email
             val body= itemView.txt_description

             name.text= comment.name
             email.text= comment.email
             body.text= comment.body

         }
    }
}


