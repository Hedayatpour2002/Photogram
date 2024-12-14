package com.example.photogram.view.post

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.photogram.data.FakeData

@Composable
fun CommentList(postID: String, commentCount : Int) {
    if (commentCount > 0) {
        Text(
            text = "View all comments",
            modifier = Modifier.padding(top = 0.dp, start = 8.dp, end = 8.dp, bottom = 16.dp)
        )
    }
}