package com.example.rxjavaretrofitroomsample

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.rxjavaretrofitroomsample.DB.ArticleDBModel
import com.squareup.picasso.Picasso

class SimpleRecyclerviewAdapter(val context: Context,var articleList : List<ArticleDBModel>) : RecyclerView.Adapter<SimpleRecyclerviewAdapter.SimpleRecyclerViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): SimpleRecyclerViewHolder{
        val view = LayoutInflater.from(context).inflate(R.layout.single_item,parent,false)
        return SimpleRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: SimpleRecyclerViewHolder, position: Int) {
        val article = articleList[position]
        holder.textview.text = article.snippet
        Picasso.get().load(article.imageUrl).into(holder.imageview)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    fun updateData(updatedArticleList : List<ArticleDBModel>){
        articleList = updatedArticleList
        notifyDataSetChanged()
    }

    inner class SimpleRecyclerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val textview : TextView = itemView.findViewById(R.id.text)
        val imageview : ImageView = itemView.findViewById(R.id.image)
    }
}