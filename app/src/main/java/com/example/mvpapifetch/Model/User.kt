package com.example.mvpapifetch.Model

data class User(
    val status_code : Int,
    val title : String,
    val message: String,
    val data : List<Data>
)
