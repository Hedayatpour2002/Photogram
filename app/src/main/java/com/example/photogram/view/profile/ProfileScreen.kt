package com.example.photogram.view.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil3.compose.AsyncImage
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.photogram.R
import com.example.photogram.data.FakeData
import com.example.photogram.ui.theme.Purple40
import com.example.photogram.ui.theme.PurpleGrey80

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun ProfileScreen() {

    Scaffold(topBar = {
        Box {
            Image(
                painter = painterResource(R.drawable.profile_bg),
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
                    .clip(BottomCurvedShape),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )

            Text(
                "@Ahmad",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                modifier = Modifier.align(Alignment.Center),
                color = Color.White
            )

            Icon(
                Icons.Outlined.Settings,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .size(32.dp)
                    .padding(end = 8.dp),
                tint = Color.White
            )

        }
    }, content = { padding ->
        BoxWithConstraints(
            modifier = Modifier
                .zIndex(10f)
                .padding(padding)

                .fillMaxSize(),
        ) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .offset(y = (-80).dp)
                    .zIndex(100f)

            ) {
                Box(
                    modifier = Modifier
                        .shadow(elevation = 10.dp, shape = CircleShape)
                        .align(Alignment.Center),
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .size(150.dp)
                            .clip(shape = CircleShape)
                            .border(
                                width = 8.dp, color = Color.White, shape = CircleShape
                            ),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(FakeData.getUserAvatarById("1"))
                            .diskCachePolicy(CachePolicy.ENABLED).crossfade(enable = true).build(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        error = painterResource(R.drawable.error_placeholder),
                        placeholder = painterResource(R.drawable.loading)
                    )
                }
            }


            Profile()
        }
    })
}

@Composable
fun Profile() {
    val outerScrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
            .verticalScroll(outerScrollState)
            .offset(y = 75.dp)

    ) {
        Text(
            text = "Ahmad Hedayatpour",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Babol, Mazandaran, Iran",
            color = Color.Gray,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .background(
                    color = PurpleGrey80.copy(alpha = 0.2f), shape = RoundedCornerShape(8.dp)
                )
                .fillMaxWidth(),
        ) {
            Button(
                onClick = {},
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            ) {
                Text(
                    text = "220",
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp,
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Followers",
                    color = Color.Gray.copy(alpha = 0.7f),
                    fontSize = 20.sp,
                )
            }
            Button(
                onClick = {},
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
            ) {
                Text(
                    text = "200",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Following",
                    color = Color.Gray.copy(alpha = 0.7f),
                    fontSize = 20.sp,
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Icon(
                painter = painterResource(R.drawable.globe_1),
                contentDescription = null,
                modifier = Modifier.size(34.dp),
            )


            Icon(
                painter = painterResource(R.drawable.u_instagram),
                contentDescription = null,
                modifier = Modifier.size(34.dp),
            )


            Icon(
                painter = painterResource(R.drawable.facebook_1),
                contentDescription = null,
                modifier = Modifier.size(34.dp),
            )
        }

        TabRowScreen()
    }
}

@Composable
fun TabRowScreen() {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabItems = listOf(
        TabItem(title = "Posts") {
            val myPosts = FakeData.getUserPosts("1");
            if (myPosts.isEmpty()) {
                Column(Modifier.height(800.dp)) {
                    Image(
                        painter = painterResource(R.drawable.no_post),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            } else {
                LazyVerticalGrid(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(800.dp),
                    columns = GridCells.Fixed(2),
                    userScrollEnabled = true,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(myPosts) { post ->
                        AsyncImage(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1f)
                                .clip(RoundedCornerShape(8.dp)),
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(post.photoAddress).diskCachePolicy(CachePolicy.DISABLED)
                                .crossfade(enable = true).build(),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            error = painterResource(R.drawable.error_placeholder),
                            placeholder = painterResource(R.drawable.loading)
                        )
                    }


                    items(2) {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1f)
                        )
                    }
                }
            }
        },

        TabItem(title = "Saved") {
            val myPosts = FakeData.getUserSavedPosts("1");
            if (myPosts.isEmpty()) {
                Column(Modifier.height(800.dp)) {
                    Image(
                        painter = painterResource(R.drawable.no_post),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            } else {
                LazyVerticalGrid(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(800.dp),
                    columns = GridCells.Fixed(2),
                    userScrollEnabled = true,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(myPosts) { post ->
                        AsyncImage(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1f)
                                .clip(RoundedCornerShape(8.dp)),
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(post.photoAddress).diskCachePolicy(CachePolicy.DISABLED)
                                .crossfade(enable = true).build(),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            error = painterResource(R.drawable.error_placeholder),
                            placeholder = painterResource(R.drawable.loading)
                        )
                    }

                    items(2) {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1f)
                        )
                    }
                }
            }
        },

        TabItem(title = "Liked") {
            val myPosts = FakeData.getUserLikedPosts("1");
            if (myPosts.isEmpty()) {
                Column(Modifier.height(800.dp)) {
                    Image(
                        painter = painterResource(R.drawable.no_post),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            } else {
                LazyVerticalGrid(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(800.dp),
                    columns = GridCells.Fixed(2),
                    userScrollEnabled = true,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(myPosts) { post ->
                        AsyncImage(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1f)
                                .clip(RoundedCornerShape(8.dp)),
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(post.photoAddress).diskCachePolicy(CachePolicy.DISABLED)
                                .crossfade(enable = true).build(),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            error = painterResource(R.drawable.error_placeholder),
                            placeholder = painterResource(R.drawable.loading)
                        )
                    }

                    items(2) {
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1f)
                        )
                    }
                }
            }
        },
    )
    val pagerState = rememberPagerState { tabItems.size }
    val offsetAmount = 50.dp
    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }

    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) selectedTabIndex = pagerState.currentPage
    }

    TabRow(
        selectedTabIndex = selectedTabIndex, modifier = Modifier.offset(y = offsetAmount)
    ) {
        tabItems.forEachIndexed { index, item ->
            Tab(
                selected = index == selectedTabIndex,
                onClick = {
                    selectedTabIndex = index
                },
                selectedContentColor = if (index == selectedTabIndex) Color.White else Color.Black,
                modifier = if (index == selectedTabIndex) {
                    Modifier
                        .clip(shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                        .background(Purple40)
                } else {
                    Modifier
                }
            ) {
                Text(
                    text = item.title,
                    modifier = Modifier.padding(16.dp),
                    fontWeight = if (selectedTabIndex == index) FontWeight.Bold else FontWeight.Medium
                )
            }
        }
    }
    HorizontalPager(
        state = pagerState, modifier = Modifier
            .offset(y = offsetAmount + 10.dp)
            .fillMaxSize()
    ) { index ->
        tabItems[index].content()
    }
}

data class TabItem(
    val title: String,
    val content: @Composable () -> Unit,
)

val BottomCurvedShape = GenericShape { size, _ ->
    moveTo(0f, 0f)
    lineTo(0f, size.height - 70)
    quadraticTo(
        size.width / 2, size.height + 70, size.width, size.height - 70
    )
    lineTo(size.width, 0f)
    close()
}

@Preview
@Composable
private fun ProfileScreenPrev() {
    ProfileScreen()
}