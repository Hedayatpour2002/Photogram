package com.example.photogram.view.post

import android.text.Layout
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.photogram.R
import com.example.photogram.data.FakeData
import com.example.photogram.model.Post

@Composable
fun PostCard(
    post: Post
) {
    val context = LocalContext.current
    val isPostLiked = remember {
        mutableStateOf(
            FakeData.isPostLikedByUser(
                postId = post.postID, userId = "1"
            )
        )
    }

    val likeCount = remember {
        mutableIntStateOf(
            FakeData.likeCount(postId = post.postID)
        )
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {

        PostHeader(userID = post.userID, postLocation = post.location)

        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .clip(RoundedCornerShape(8.dp))
                .pointerInput(Unit) {
                    detectTapGestures(onDoubleTap = {
                        if (isPostLiked.value) {
                            Toast
                                .makeText(context, "unLiked by DoubleTap", Toast.LENGTH_SHORT)
                                .show()
                            FakeData.removeLike(userId = "1", postId = post.postID)
                        } else {
                            Toast
                                .makeText(context, "Liked by DoubleTap", Toast.LENGTH_SHORT)
                                .show()
                            FakeData.addLike(userId = "1", postId = post.postID)
                        }

                        isPostLiked.value = !isPostLiked.value
                        likeCount.intValue = FakeData.likeCount(postId = post.postID)
                    })
                },
            model = ImageRequest.Builder(LocalContext.current).data(post.photoAddress)
                .diskCachePolicy(CachePolicy.DISABLED).crossfade(enable = true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            error = painterResource(R.drawable.error_placeholder),
            placeholder = painterResource(R.drawable.loading)
        )

        PostDetails(
            postId = post.postID,
            userId = post.userID,
            title = post.title,
            description = post.description,
            isPostLiked = isPostLiked,
            likeCount = likeCount
        )
    }
}
