package com.example.photogram.view.post

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.photogram.R
import com.example.photogram.data.FakeData
import com.example.photogram.model.Comment

@Composable
fun CommentInput(
    postId: String,
    userId: String,
    commentCount: MutableIntState,
    commentList: MutableState<List<Comment>>
) {
    val commentContent = remember {
        mutableStateOf("")
    }
    var isErrorComment by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(modifier = Modifier
            .weight(1f)
            .padding(end = 8.dp),
            value = commentContent.value,
            singleLine = true,
            onValueChange = { newText ->
                commentContent.value = newText
                isErrorComment = false
            },
            isError = isErrorComment,
            shape = RoundedCornerShape(50),
            label = {
                Text(text = "Enter your comment")
            })
        Button(
            onClick = {
                if (commentContent.value.isNotEmpty()) {
                    val newComment =
                        Comment(postID = postId, userID = "1", content = commentContent.value)
                    FakeData.addComment(newComment)
                    commentContent.value = ""
                    commentCount.intValue = FakeData.commentCount(postId)
                    commentList.value = FakeData.getAllCommentsByPostID(postId = postId)
                } else {
                    isErrorComment = true
                }
            },
            modifier = Modifier.fillMaxHeight(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White, contentColor = Color.Black
            ),
            border = BorderStroke(1.dp, Color.Gray),
        ) {
            Row(
                modifier = Modifier.padding(vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Send", modifier = Modifier.padding(end = 4.dp))
                Icon(painter = painterResource(R.drawable.send), contentDescription = null)

            }
        }

    }
}