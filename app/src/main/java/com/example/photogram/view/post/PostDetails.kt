package com.example.photogram.view.post

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.photogram.data.FakeData

@Composable
fun PostDetails(
    postId: String, userId: String, title: String, description: String
) {
    val commentCount = remember {
        mutableIntStateOf(
            FakeData.commentCount(postId = postId)
        )
    }
    PostActions(
        postID = postId,
        title = title,
        description = description,
        commentCount = commentCount.intValue
    )

    PostContent(title = title, description = description)
    CommentInput(postId = postId, userId = userId, commentCount = commentCount)
    CommentList(postID = postId, commentCount.intValue)


}