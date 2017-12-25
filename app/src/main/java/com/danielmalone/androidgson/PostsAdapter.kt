package com.danielmalone.androidgson

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.danielmalone.androidgson.model.Post

class PostsAdapter(val posts: List<Post>) : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.title.text = posts[position].title
    }

    override fun getItemCount() = posts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.row_posts, parent, false)
        return PostsViewHolder(view)
    }

    class PostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
    }
}