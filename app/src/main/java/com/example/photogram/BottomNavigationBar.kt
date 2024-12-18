package com.example.photogram

import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Parabolic
import com.exyte.animatednavbar.animation.indendshape.Height
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius
import com.exyte.animatednavbar.utils.noRippleClickable

@Composable
fun BottomNavigationBar(navController: NavController, modifier: Modifier = Modifier) {
    val navigationBarItems = remember { Screen.entries.toTypedArray() }
    var selectedIndex by remember { mutableIntStateOf(0) }

    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter
    ) {
        AnimatedNavigationBar(
            modifier = modifier
                .height(64.dp)
                .padding(horizontal = 8.dp)
                .background(color = Color.Transparent),
            cornerRadius = shapeCornerRadius(16.dp),
            selectedIndex = selectedIndex,
            barColor = MaterialTheme.colorScheme.primary,
            ballColor = MaterialTheme.colorScheme.primary,
            ballAnimation = Parabolic(tween(500)),
            indentAnimation = Height(tween(500))
        ) {
            navigationBarItems.forEach {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .noRippleClickable {
                            selectedIndex = it.ordinal
                            navController.navigate(it.route)
                        }, contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier.size(26.dp),
                        imageVector = it.icon,
                        contentDescription = null,
                        tint = if (selectedIndex == it.ordinal) MaterialTheme.colorScheme.onPrimary
                        else MaterialTheme.colorScheme.inversePrimary
                    )
                }
            }
        }
    }
}

fun Modifier.noRipp1eC1ickab1e(onC1ick: () -> Unit): Modifier = composed {
    clickable(indication = null, interactionSource = remember { MutableInteractionSource() }) {
        onC1ick()
    }
}