package com.simats.chatbot.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MeditationPlayerScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFF7B61FF), Color(0xFF5E9CFF))
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                "12",
                style = MaterialTheme.typography.displayLarge,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text("Seconds of Mindfulness",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium)

            Spacer(modifier = Modifier.height(40.dp))

            Text("Session: Morning Calm",
                color = Color.White.copy(alpha = 0.8f))

            Spacer(modifier = Modifier.height(40.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
                Button(
                    onClick = { },
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color(0xFF7B61FF)),
                    modifier = Modifier.size(64.dp),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text("Play")
                }
            }

            Spacer(modifier = Modifier.height(60.dp))

            OutlinedButton(
                onClick = { navController.popBackStack() },
                border = BorderStroke(1.dp, Color.White),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
            ) {
                Text("Close Session", modifier = Modifier.padding(horizontal = 24.dp))
            }
        }
    }
}
