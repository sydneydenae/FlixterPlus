package com.example.latestmovie3

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.latestmovie3.R.id

const val MOVIE_EXTRA = "MOVIE_EXTRA"
private const val TAG = "RecyclerView/"


class MoviesRecyclerViewAdapter(
    private val movieList: List<Movie>,
    private val listener: OnListFragmentInteractionListener?


) : RecyclerView.Adapter<MoviesRecyclerViewAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mItem: Movie? = null
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        val ivPoster: ImageView = itemView.findViewById<View>(id.ivPoster) as ImageView
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]

        holder.mItem = movie
        holder.tvTitle.text = movie.title
        holder.tvDescription.text = movie.overview

        holder.itemView.setOnClickListener {
            holder.mItem?.let { movie ->
                listener?.onItemClick(movie)
            }
        }

        // load image
        Log.i(TAG, "Image Link: ${"https://image.tmdb.org/t/p/w500/"+movie.poster_path}")
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w500/"+movie.poster_path)
            .centerInside()
            .into(holder.ivPoster)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }


}