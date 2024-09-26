package com.example.latestmovie3

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Load MoviesFragment into the activity
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MoviesFragment())
                .commit()
        }
    }

    // Implementation of the OnListFragmentInteractionListener interface
    override fun onListFragmentInteraction(item: Movie) {
        // Handle the movie item click event
        Toast.makeText(this, "Selected: ${item.title}", Toast.LENGTH_SHORT).show()
    }
}