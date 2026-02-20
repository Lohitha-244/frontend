package com.simats.chatbot.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun BreathingScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFF4FACFE), Color(0xFF00F2FE))
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                "4",
                style = MaterialTheme.typography.displayLarge,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text("Breathe In Deeply",
                color = Color.White,
                style = MaterialTheme.typography.headlineSmall)

            Spacer(modifier = Modifier.height(60.dp))

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color(0xFF00B2FE)),
                shape = RoundedCornerShape(28.dp),
                modifier = Modifier.height(56.dp).padding(horizontal = 32.dp)
            ) {
                Text("Start Exercise")
            }

            Spacer(modifier = Modifier.height(24.dp))

            TextButton(
                onClick = { navController.popBackStack() }
            ) {
                Text("Finish", color = Color.White)
            }
        }
    }
}
