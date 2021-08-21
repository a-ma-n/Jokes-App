package com.aman.jokesapp

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface JokesApi {
    @GET("random_ten")
    fun getJokes(): Call<List<Jokes>>
}