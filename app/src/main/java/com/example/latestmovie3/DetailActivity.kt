package com.example.latestmovie3

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity(){
    private lateinit var titleTextView: TextView
    private lateinit var descriptionTextView: TextView
    private lateinit var posterImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // TODO: Find the views for the screen
        titleTextView = findViewById(R.id.titleTextView)
        descriptionTextView = findViewById(R.id.descriptionTextView)
        posterImageView = findViewById(R.id.posterImageView)

        // TODO: Get the extra from the Intent
        val movie = intent.getSerializableExtra(MOVIE_EXTRA) as Movie

        // TODO: Set the title, byline, and abstract information from the article
        titleTextView.text = movie.title
        descriptionTextView.text = movie.overview

        // TODO: Load the media image
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/"+movie.poster_path)
            .centerInside()
            .into(posterImageView)
    }
}