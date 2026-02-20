package com.simats.chatbot.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AffirmationScreen(navController: NavController) {
    val affirmations = listOf(
        "I am surrounded by love and support.",
        "I am calm, centered, and at peace.",
        "I believe in my ability to get through tough times.",
        "My feelings are valid and I am learning to manage them.",
        "I deserve happiness and well-being."
    )

    var index by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF48FB1))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.9f))
        ) {
            Text(
                affirmations[index],
                modifier = Modifier.padding(40.dp),
                color = Color(0xFFAD1457),
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        Button(
            onClick = {
                index = (index + 1) % affirmations.size
            },
            modifier = Modifier.height(56.dp).padding(horizontal = 32.dp),
            shape = RoundedCornerShape(28.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color(0xFFAD1457))
        ) {
            Text("Next Affirmation")
        }

        Spacer(modifier = Modifier.height(24.dp))
        
        TextButton(onClick = { navController.popBackStack() }) {
            Text("Go Back", color = Color.White)
        }
    }
}
