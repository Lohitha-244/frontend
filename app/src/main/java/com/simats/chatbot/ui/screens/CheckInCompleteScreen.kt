package com.simats.chatbot.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun CheckInCompleteScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFFBFAFF))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        // --- SUCCESS ICON ---
        Box(
            modifier = Modifier
                .size(140.dp)
                .shadow(20.dp, CircleShape)
                .clip(CircleShape)
                .background(Color(0xFF00E676)), // Vibrant Green
            contentAlignment = Alignment.Center
        ) {
            Icon(
                Icons.Default.Check,
                contentDescription = "Success",
                tint = Color.White,
                modifier = Modifier.size(80.dp)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // --- TITLE & SUBTITLE ---
        Text(
            text = "Check-In Complete!",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4A148C),
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        Text(
            text = "Thank you for sharing how you're\nfeeling",
            fontSize = 18.sp,
            color = Color(0xFF7B1FA2),
            textAlign = TextAlign.Center,
            lineHeight = 24.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(48.dp))

        // --- STATUS CARDS ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(8.dp, RoundedCornerShape(32.dp)),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF3E5F5).copy(alpha = 0.5f))
        ) {
            Row(
                modifier = Modifier.padding(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier.size(64.dp).shadow(4.dp, CircleShape),
                    shape = CircleShape,
                    color = Color.White
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(Icons.Default.AutoAwesome, contentDescription = null, tint = Color(0xFFAB47BC), modifier = Modifier.size(28.dp))
                    }
                }
                Spacer(modifier = Modifier.width(20.dp))
                Column {
                    Text(text = "Your Mood: Okay", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4A148C))
                    Text(
                        text = "Based on your responses,\nwe recommend some\ncalming exercises",
                        fontSize = 13.sp,
                        color = Color(0xFF7B1FA2),
                        lineHeight = 18.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(8.dp, RoundedCornerShape(32.dp)),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Row(
                modifier = Modifier.padding(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier.size(64.dp).shadow(2.dp, CircleShape),
                    shape = CircleShape,
                    color = Color(0xFFF3E5F5).copy(alpha = 0.5f)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(Icons.Default.TrendingUp, contentDescription = null, tint = Color(0xFFAB47BC), modifier = Modifier.size(28.dp))
                    }
                }
                Spacer(modifier = Modifier.width(20.dp))
                Column {
                    Text(text = "View Your History", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4A148C))
                    Text(text = "Track your mood over time", fontSize = 13.sp, color = Color(0xFF7B1FA2))
                }
            }
        }

        Spacer(modifier = Modifier.height(64.dp))

        // --- ACTION BUTTONS ---
        Button(
            onClick = { navController.navigate("analytics") },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .shadow(12.dp, RoundedCornerShape(32.dp)),
            shape = RoundedCornerShape(32.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color(0xFF42A5F5), Color(0xFFAB47BC))
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text("Get Personalized Suggestions", color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
            onClick = { navController.navigate("home") },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .shadow(4.dp, RoundedCornerShape(32.dp)),
            shape = RoundedCornerShape(32.dp),
            border = BorderStroke(1.dp, Color(0xFFE1BEE7)),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF7B1FA2), containerColor = Color.White)
        ) {
            Text("Back to Home", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
        
        Spacer(modifier = Modifier.height(40.dp))
    }
}
