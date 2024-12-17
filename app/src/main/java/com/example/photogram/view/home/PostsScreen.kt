package com.example.photogram.view.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.photogram.data.FakeData
import com.example.photogram.view.post.PostCard

@Composable
fun PostsScreen() {
    LazyColumn {
        items(FakeData.getPosts()) { post ->
            PostCard(post)
        }
    }
}