package com.example.photogram.view.post

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.photogram.R
import com.example.photogram.data.FakeData

@Composable
fun PostHeader(userID: String, postLocation: String) {
    var isMenuExpanded by remember { mutableStateOf(false) }
    val menuItems = listOf(
        "Option 1",
        "Option 2",
        "Option 3",
        "Option 4",
        "Option 5",
    )
    Row(modifier = Modifier.padding(start = 8.dp, top = 16.dp, bottom = 8.dp)) {
        AsyncImage(
            modifier = Modifier
                .size(50.dp)
                .clip(shape = CircleShape),
            model = ImageRequest.Builder(LocalContext.current)
                .data(FakeData.getUserAvatarById(userID)).diskCachePolicy(CachePolicy.DISABLED)
                .crossfade(enable = true).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            error = painterResource(R.drawable.error_placeholder),
            placeholder = painterResource(R.drawable.loading)

        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            FakeData.getUserNameById(userID)
                ?.let { Text(text = it, style = MaterialTheme.typography.titleMedium) }
            Text(text = postLocation, style = MaterialTheme.typography.bodyMedium)
        }
        Box() {
            IconButton(onClick = { isMenuExpanded = true }) {
                Icon(Icons.Filled.MoreVert, contentDescription = "More options")
            }
            DropdownMenu(
                expanded = isMenuExpanded,
                onDismissRequest = { isMenuExpanded = false },
                modifier = Modifier.background(
                    Color.White
                )
            ) {
                menuItems.forEach() {
                    DropdownMenuItem(
                        onClick = { isMenuExpanded = false },
                        text = { Text(text = it) },
                    )
                }
            }
        }
    }
}