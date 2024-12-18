package com.example.photogram.view.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun SearchScreen(modifier: Modifier = Modifier) {
    var searchText by remember { mutableStateOf("") }
    var filteredUsers by remember { mutableStateOf(FakeData.searchUsersByUsername("")) }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        OutlinedTextField(value = searchText, onValueChange = {
            searchText = it
            filteredUsers = FakeData.searchUsersByUsername(searchText)
        }, placeholder = { Text("Search") }, modifier = Modifier.fillMaxWidth()
        )

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            if (filteredUsers.isEmpty() && searchText.isNotEmpty()) {
                item {
                    BasicText(
                        text = "No results found.",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }
            } else {
                items(filteredUsers.size) { index ->
                    Row(
                        modifier = Modifier.padding(start = 8.dp, top = 16.dp, bottom = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        AsyncImage(
                            modifier = Modifier
                                .size(50.dp)
                                .clip(shape = CircleShape),
                            model = ImageRequest.Builder(LocalContext.current).data(
                                filteredUsers[index].avatar
                            ).diskCachePolicy(CachePolicy.DISABLED).crossfade(enable = true)
                                .build(),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            error = painterResource(R.drawable.error_placeholder),
                            placeholder = painterResource(R.drawable.loading)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = filteredUsers[index].userName,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        }
    }
}
