package com.example.photogram.view.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.photogram.data.FakeData
import com.example.photogram.view.post.PostCard

@Composable
fun PostsScreen(listState: LazyListState) {
    LazyColumn (state = listState){
        items(FakeData.getPosts()) { post ->
            PostCard(post)
        }
        item() {
            Spacer(modifier = Modifier.height(80.dp))
        }
    }

//    LaunchedEffect(Unit) {
//        listState.scrollToItem(0)
//    }
}