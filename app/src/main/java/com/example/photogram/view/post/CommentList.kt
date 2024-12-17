package com.example.photogram.view.post

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.photogram.data.FakeData
import com.example.photogram.model.Comment

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommentList(postID: String, commentCount: Int, commentList: List<Comment>) {
    if (commentCount > 0) {
        val sheetState = rememberModalBottomSheetState()
        var isSheetOpen by remember { mutableStateOf(false) }
        TextButton(onClick = {
            isSheetOpen = true
        }) {
            Text(text = "View all comments")
        }

        if (isSheetOpen) {
            ModalBottomSheet(sheetState = sheetState, onDismissRequest = {
                isSheetOpen = false
            }) {
                Column(
                    modifier = Modifier
                        .verticalScroll(
                            rememberScrollState()
                        )
                        .padding(8.dp),
                ) {
                    commentList.forEach() {
                        Row(
                            modifier = Modifier
                                .padding(start = 8.dp, top = 16.dp, bottom = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            AsyncImage(
                                modifier = Modifier
                                    .size(50.dp)
                                    .clip(shape = CircleShape),
                                model = FakeData.getUserAvatarById(it.userID),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            FakeData.getUserNameById(it.userID)
                                ?.let {
                                    Text(
                                        text = it,
                                        style = MaterialTheme.typography.titleMedium
                                    )
                                }
                            Spacer(modifier = Modifier.width(16.dp))

                            Text(text = it.content, modifier = Modifier.weight(1f))
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    } else
        Spacer(modifier = Modifier.height(16.dp))
}