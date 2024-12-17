package com.example.photogram.view.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(listState: LazyListState) {
    Column(modifier = Modifier.fillMaxSize()) {
        HomeHeader()
        PostsScreen(listState = listState)
    }
}