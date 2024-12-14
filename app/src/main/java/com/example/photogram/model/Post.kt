package com.example.photogram.model

data class Post(
    val postID : String,
    val userID: String,
    val location: String,
    val photoAddress: String,
    val title: String,
    val description: String,
)
