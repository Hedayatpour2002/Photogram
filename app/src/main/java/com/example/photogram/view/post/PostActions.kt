package com.example.photogram.view.post

import android.content.Intent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.photogram.R
import com.example.photogram.data.FakeData

@Composable
fun PostActions(
    postID: String,
    title: String,
    description: String,
    commentCount: Int,
    isPostLiked:
    MutableState<Boolean>,
    likeCount: MutableIntState
) {

    val isBookmarked = remember {
        mutableStateOf(
            FakeData.isPostBookmarkedByUser(
                postId = postID, userId = "1"
            )
        )
    }
    val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, "${title}\n${description}")
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, null)
    val context = LocalContext.current

    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

        IconButton(onClick = {

            if (isPostLiked.value) {
                FakeData.removeLike(userId = "1", postId = postID)
            } else {
                FakeData.addLike(userId = "1", postId = postID)
            }

            isPostLiked.value = !isPostLiked.value
            likeCount.intValue = FakeData.likeCount(postId = postID)
        }) {
            Icon(
                imageVector = if (isPostLiked.value) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                contentDescription = "Like",
                tint = Color.Red
            )

        }
        Text(text = likeCount.intValue.toString())

        Spacer(modifier = Modifier.width(4.dp))
        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(id = R.drawable.comment), contentDescription = "Comment"
            )
        }
        Text(text = commentCount.toString())

        Spacer(modifier = Modifier.width(4.dp))
        IconButton(onClick = {
            context.startActivity(shareIntent)
        }) {
            Icon(painter = painterResource(id = R.drawable.share), contentDescription = "Share")
        }

        Spacer(modifier = Modifier.weight(1f))

        if ((isBookmarked.value)) {
            IconButton(onClick = {
                isBookmarked.value = false
                FakeData.removeBookmark(userId = "1", postId = postID)
            }) {
                Icon(
                    painter = painterResource(R.drawable.bookmark),
                    contentDescription = "bookmark",
                    tint = Color.Black
                )
            }
        } else {
            IconButton(onClick = {
                isBookmarked.value = true
                FakeData.addBookmark(userId = "1", postId = postID)
            }) {
                Icon(
                    painter = painterResource(R.drawable.bookmark_border),
                    contentDescription = "remove from bookmark"
                )
            }
        }
    }
}