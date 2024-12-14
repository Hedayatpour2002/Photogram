package com.example.photogram.view.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.photogram.data.FakeData

@Composable
fun ProfileScreen(modifier : Modifier = Modifier) {
    Column {
        AsyncImage(
            modifier = Modifier
                .size(50.dp)
                .clip(shape = CircleShape),
            model = FakeData.getUserAvatarById("1"),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
    }
}