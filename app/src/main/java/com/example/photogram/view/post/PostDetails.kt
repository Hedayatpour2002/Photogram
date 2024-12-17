package com.example.photogram.view.post

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.photogram.data.FakeData

@Composable
fun PostDetails(
    postId: String,
    userId: String,
    title: String,
    description: String,
    isPostLiked:
    MutableState<Boolean>,
    likeCount: MutableIntState
) {
    val commentCount = remember {
        mutableIntStateOf(
            FakeData.commentCount(postId = postId)
        )
    }
    val commentList = remember { mutableStateOf(FakeData.getAllCommentsByPostID(postId = postId)) }

    PostActions(
        postID = postId,
        title = title,
        description = description,
        commentCount = commentCount.intValue,
        isPostLiked = isPostLiked,
        likeCount = likeCount
    )

    PostContent(title = title, description = description)
    CommentInput(
        postId = postId,
        userId = userId,
        commentCount = commentCount,
        commentList = commentList
    )
    CommentList(postID = postId, commentCount.intValue, commentList = commentList.value)
}

