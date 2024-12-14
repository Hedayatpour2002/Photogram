package com.example.photogram.view.home

import com.example.photogram.data.FakeData
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.photogram.view.post.PostCard

@Composable
fun PostsScreen(modifier: Modifier = Modifier) {

    Column (modifier = Modifier.verticalScroll(rememberScrollState())){

        FakeData.getPosts().forEach {
            PostCard(it)
        }
    }


}