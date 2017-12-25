package com.danielmalone.androidgson

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.danielmalone.androidgson.model.Post
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    companion object {
        const val URL = "https://jsonplaceholder.typicode.com/posts"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        doAsync {
            val response: String = java.net.URL(URL).readText()
            uiThread {
                val posts = processJson(response)
                show(posts)
            }
        }
    }

    fun processJson(json: String): List<Post> {
        val gson: Gson = GsonBuilder().create()
        val posts: List<Post> = gson.fromJson(json, Array<Post>::class.java).toList()

        return posts
    }

    fun show(posts: List<Post>) {
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = PostsAdapter(posts)
    }
}
