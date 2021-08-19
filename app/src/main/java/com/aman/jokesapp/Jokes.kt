package com.aman.jokesapp

import com.google.gson.annotations.SerializedName

data class Jokes (
    val id: Int,
    val type: String,
    val setup: String,
    val punchline: String
)