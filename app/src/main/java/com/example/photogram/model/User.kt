package com.example.photogram.model

data class User(
    val userID: String,
    var avatar: String = "https://cdn-icons-png.flaticon.com/512/10337/10337609.png",
    var userName: String,
    var bio: String
)
