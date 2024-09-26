package com.example.latestmovie3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieAdapter: MoviesRecyclerViewAdapter
    private lateinit var movieList: List<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Create a list of movies (example data)
        movieList = listOf(
           // Movie("Inception", "A mind-bending thriller", R.drawable.inception_poster),
        )

        // Set the adapter to insert info
        movieAdapter = MoviesRecyclerViewAdapter(movieList, this)
        recyclerView.adapter = movieAdapter
    }
}