package com.example.photogram.view.post

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.photogram.data.FakeData
import com.example.photogram.model.Post

@Composable
fun PostHeader(userID : String, postLocation : String) {
    Row(modifier = Modifier.padding(start = 8.dp, top = 16.dp, bottom = 8.dp)) {

        AsyncImage(
            modifier = Modifier
                .size(50.dp)
                .clip(shape = CircleShape),
            model = FakeData.getUserAvatarById(userID),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            FakeData.getUserNameById(userID)
                ?.let { Text(text = it, style = MaterialTheme.typography.titleMedium) }
            Text(text = postLocation, style = MaterialTheme.typography.bodyMedium)
        }
        IconButton(onClick = { /* TODO */ }) {
            Icon(Icons.Filled.MoreVert, contentDescription = "More options")
        }
    }
}