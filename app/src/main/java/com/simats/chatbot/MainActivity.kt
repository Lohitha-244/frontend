package com.simats.chatbot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.simats.chatbot.ui.navigation.AppNavigation
import com.simats.chatbot.ui.components.BottomNavBar
import com.simats.chatbot.ui.theme.ChatbotTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatbotTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    SolaceApp()
                }
            }
        }
    }
}

@Composable
fun SolaceApp() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != "welcome" && currentRoute != "login") {
                BottomNavBar(navController)
            }
        }
    ) { padding ->
        AppNavigation(navController = navController, paddingValues = padding)
    }
}
