package com.aman.jokesapp

import com.google.gson.annotations.SerializedName

data class Jokes (
    var id: Int,
    var type: String,
    var setup: String,
    var punchline: String
)