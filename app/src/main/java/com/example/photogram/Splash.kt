package com.example.photogram

import android.graphics.drawable.Animatable
import android.widget.ImageView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onAnimationEnd: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        AndroidView(modifier = Modifier.fillMaxSize(), factory = { ctx ->
            ImageView(ctx).apply {
                setImageDrawable(ContextCompat.getDrawable(ctx, R.drawable.photogram_anim))
                (drawable as? Animatable)?.start()
            }
        })
    }
    LaunchedEffect(Unit) {
        delay(1000)
        onAnimationEnd()
    }
}