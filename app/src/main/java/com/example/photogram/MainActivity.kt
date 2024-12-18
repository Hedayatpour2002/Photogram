package com.example.photogram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.photogram.ui.theme.PhotogramTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var showSplash by remember { mutableStateOf(true) }
            val navController = rememberNavController()

            PhotogramTheme {
                if (showSplash) {
                    SplashScreen {
                        showSplash = false
                    }
                } else {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        bottomBar = {
                        }) { innerPadding ->
                        NavigationHost(
                            navController = navController, modifier = Modifier.padding(innerPadding)
                        )
                        BottomNavigationBar(navController = navController, modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}

