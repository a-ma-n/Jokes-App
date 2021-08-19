package com.aman.jokesapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var joke = ArrayList<Jokes>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv: RecyclerView = findViewById(R.id.rvJokes)
        var ja: JokesAdapter = JokesAdapter(joke)

        rv.layoutManager = LinearLayoutManager(this)
        rv.setHasFixedSize(true)
        rv.adapter = ja

        RetrofitInstance.api.getTodos().enqueue(object : Callback<List<Jokes>> {

            override fun onResponse(call: Call<List<Jokes>>, response: Response<List<Jokes>>) {
                if (response.message() == "OK") {
                    joke = ArrayList(response.body()!!)

                    Log.d("apicall", joke.toString())

                    ja.jokes = joke
                    ja.notifyDataSetChanged()
                } else {
                    Log.d("apicall", response.message())

                }

            }

            override fun onFailure(call: Call<List<Jokes>>, t: Throwable) {
                Log.d("apicall", t.message.toString())
            }
        })
    }
}