package com.example.latestmovie3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.latestmovie3.R.id



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val supportFragmentManager = supportFragmentManager
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(id.fragment_container, MoviesFragment(), null).commit()
        // figure out how to reference this id
    }
}