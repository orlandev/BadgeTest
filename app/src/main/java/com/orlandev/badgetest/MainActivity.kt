package com.orlandev.badgetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.orlandev.badgetest.ui.theme.BadegTestTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BadegTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {

                    var count by remember {
                        mutableStateOf(0)
                    }

                    NavigationBar {
                        NavigationBarItem(icon = {
                            BadgedBox(badge = {
                                Badge {
                                    Text(text = "$count")
                                }
                            }) {
                                Icon(Icons.Default.Newspaper, contentDescription = "News")
                            }
                        }, selected = false, onClick = {
                            count++

                        })
                    }
                }
            }
        }
    }
}
