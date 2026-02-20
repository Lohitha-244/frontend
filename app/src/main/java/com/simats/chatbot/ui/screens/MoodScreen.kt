package com.simats.chatbot.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MoodScreen(navController: NavController) {
    var selectedMood by remember { mutableStateOf("Okay") }
    var stressLevel by remember { mutableStateOf(0.5f) }

    val moods = listOf(
        MoodItem("Great", "😁"),
        MoodItem("Good", "😊"),
        MoodItem("Okay", "😐"),
        MoodItem("Not Great", "😒"),
        MoodItem("Struggling", "😢")
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFBFAFF))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Back Button
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color(0xFF6200EE))
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Title
            Text(
                text = "How are you feeling?",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4A148C)
            )

            Text(
                text = "Select the mood that best describes how you feel right now",
                fontSize = 16.sp,
                color = Color(0xFFAB47BC).copy(alpha = 0.8f),
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Mood Selection List
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                moods.forEach { item ->
                    MoodCard(
                        item = item,
                        isSelected = selectedMood == item.name,
                        onClick = { selectedMood = item.name }
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Stress Level Section
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(4.dp, RoundedCornerShape(24.dp)),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(24.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Stress Level",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF4A148C)
                        )
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                Icons.Default.Bolt,
                                contentDescription = null,
                                tint = Color(0xFFFFB300),
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "5/10",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFF6A1B9A)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Custom Slider/Progress
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(12.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFF3E5F5))
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(stressLevel)
                                .fillMaxHeight()
                                .background(Color(0xFFCE93D8), CircleShape)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Low", fontSize = 12.sp, color = Color(0xFFAB47BC))
                        Text("High", fontSize = 12.sp, color = Color(0xFFAB47BC))
                    }
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Continue Button
            Button(
                onClick = { navController.navigate("checkin") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .shadow(8.dp, RoundedCornerShape(32.dp)),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                shape = RoundedCornerShape(32.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color(0xFF42A5F5),
                                    Color(0xFFAB47BC)
                                )
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Continue",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun MoodCard(item: MoodItem, isSelected: Boolean, onClick: () -> Unit) {
    val modifier = if (isSelected) {
        Modifier
            .fillMaxWidth()
            .height(80.dp)
            .shadow(12.dp, RoundedCornerShape(20.dp))
            .clip(RoundedCornerShape(20.dp))
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFFFFB300),
                        Color(0xFFFF9100)
                    )
                )
            )
            .clickable { onClick() }
    } else {
        Modifier
            .fillMaxWidth()
            .height(80.dp)
            .shadow(4.dp, RoundedCornerShape(20.dp))
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .clickable { onClick() }
    }

    Box(modifier = modifier, contentAlignment = Alignment.CenterStart) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = item.emoji, fontSize = 28.sp)
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = item.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isSelected) Color.Black else Color(0xFF4A148C)
                )
            }
            if (isSelected) {
                Icon(
                    Icons.Default.Favorite,
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

data class MoodItem(val name: String, val emoji: String)
