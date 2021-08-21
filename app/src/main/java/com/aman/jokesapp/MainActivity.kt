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

    private var jokes = ArrayList<Jokes>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv: RecyclerView = findViewById(R.id.rvJokes)
        var ja: JokesAdapter=JokesAdapter(jokes)

//        jokes.add(Jokes(123,"general","setup", "punchline" ))

        rv.layoutManager = LinearLayoutManager(this)
        rv.setHasFixedSize(true)
        rv.adapter = ja


        RetrofitInstance.api.getJokes().enqueue(object : Callback<List<Jokes>> {

            override fun onResponse(call: Call<List<Jokes>>, response: Response<List<Jokes>>)
            {


                    jokes = ArrayList(response.body()!!)
                    Log.d("MainActivity", jokes.toString())
                    ja.jokeList = jokes
                    ja.notifyDataSetChanged()

//                }
//                else if(response.body()==null)
//                {
//                    Log.d("MainActivity", response.message())
//                }
            }

            override fun onFailure(call: Call<List<Jokes>>, t: Throwable) {
                Log.d("apicall", t.message.toString())
            }
        })
    }
}