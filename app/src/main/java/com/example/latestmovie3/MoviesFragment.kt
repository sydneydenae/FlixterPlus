package com.example.latestmovie3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.ContentLoadingProgressBar
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestParams
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


private const val API_KEY = "a07e22bc18f5cb106bfe4cc1f83ad8ed"


class MoviesFragment : Fragment(), OnListFragmentInteractionListener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflates the fragment view and assigns it to a variable
        val view = inflater.inflate(R.layout.fragment_movies_list, container, false)
        val progressBar = view.findViewById<View>(R.id.progressBar) as ContentLoadingProgressBar
        // everything is mostly in the recycler view
        val recyclerView = view.findViewById<View>(R.id.recyclerView) as RecyclerView
        val context = view.context
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        // calls updateAdapter to update the recycler view
        updateAdapter(progressBar, recyclerView)
        return view
    }

    /*
     * Updates the RecyclerView adapter with new data.  This is where the
     * networking magic happens!
     */
    private fun updateAdapter(progressBar: ContentLoadingProgressBar, recyclerView: RecyclerView) {
        progressBar.show()

        // Create and set up an AsyncHTTPClient() here
        val client = AsyncHttpClient()
        val params = RequestParams()
        params["api-key"] = API_KEY

        // Using the client, perform the HTTP request
        client[
            // what should the client be in this instance
            "https://api.themoviedb.org/3/movie/now_playing?&api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed",
            params,
            object : JsonHttpResponseHandler()
            {
                /*
                 * The onSuccess function gets called when
                 * HTTP response status is "200 OK"
                 */
                override fun onSuccess(
                    statusCode: Int,
                    headers: Headers,
                    json: JsonHttpResponseHandler.JSON
                ) {
                    // The wait for a response is over
                    progressBar.hide()

                    // Log full JSON response
                    Log.d("Latest Movies", json.toString())

                    // Get the "results" JSONArray directly from the response.
                    val moviesRawJSON = json.jsonObject.getJSONArray("results").toString()

                    // Create a Gson object
                    val gson = Gson()

                    // Define the type of the list of BestSellerBook
                    val arrayBookType = object : TypeToken<List<Movie>>() {}.type

                    // Parse the JSON into a list of BestSellerBook objects
                    val models: List<Movie> = gson.fromJson(moviesRawJSON, arrayBookType)

                    // Set the adapter with the parsed data
                    recyclerView.adapter = MoviesRecyclerViewAdapter(models, this@MoviesFragment)

                    // Look for this in Logcat:
                    Log.d("BestSellerBooksFragment", "response successful")
                }

                /*
                 * The onFailure function gets called when
                 * HTTP response status is "4XX" (eg. 401, 403, 404)
                 */
                override fun onFailure(
                    statusCode: Int,
                    headers: Headers?,
                    errorResponse: String,
                    t: Throwable?
                ) {
                    // The wait for a response is over
                    progressBar.hide()

                    // If the error is not null, log it!
                    t?.message?.let {
                        Log.e("BestSellerBooksFragment", errorResponse)
                    }
                }
            }]
    }

    override fun onItemClick(item: Movie) {
        Toast.makeText(context, "test: " + item.title, Toast.LENGTH_LONG).show()
        val intent = Intent(context, DetailActivity::class.java) // Make sure to create this Activity
        intent.putExtra(MOVIE_EXTRA, item)
        startActivity(intent)
    }


}
