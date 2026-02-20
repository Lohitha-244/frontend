package com.simats.chatbot.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White)
    ) {
        // --- HIGH-FIDELITY GRADIENT HEADER ---
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(10.dp, RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF9C27B0), // Purple
                            Color(0xFFE91E63), // Pink
                            Color(0xFFD81B60)  // Deep Pink
                        )
                    )
                )
                .padding(20.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            modifier = Modifier.size(48.dp),
                            shape = CircleShape,
                            color = Color.White.copy(alpha = 0.2f)
                        ) {
                            Icon(
                                Icons.Default.Person,
                                contentDescription = null,
                                tint = Color.Black,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                "Welcome back!",
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                "Tuesday, February 3",
                                color = Color.Black.copy(alpha = 0.8f),
                                fontSize = 14.sp
                            )
                        }
                    }
                    IconButton(onClick = { navController.navigate("settings") }) {
                        Icon(Icons.Outlined.Settings, contentDescription = "Settings", tint = Color.Black)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Stats Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    StatCard("Level", "1", Icons.Default.EmojiEvents)
                    StatCard("Streak", "0", Icons.Default.Whatshot, "days")
                    StatCard("Coins", "0", Icons.Default.Star)
                }

                Spacer(modifier = Modifier.height(24.dp))

                // XP Progress
                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("XP Progress", color = Color.Black, fontSize = 12.sp)
                        Text("0/100", color = Color.Black, fontSize = 12.sp)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                            .background(Color.White.copy(alpha = 0.3f), CircleShape)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.05f) // Small progress
                                .fillMaxHeight()
                                .background(Color(0xFFFFEB3B), CircleShape)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // --- QUOTE CARD ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF3E5F5))
        ) {
            Row(
                modifier = Modifier.padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.Message, // Standard icon
                    contentDescription = null,
                    tint = Color(0xFFA1887F),
                    modifier = Modifier.size(32.dp).graphicsLayer(rotationZ = 180f)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        "\"You are stronger than you think.\"",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color(0xFF6A1B9A),
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        "Daily motivation",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFF9C27B0)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            "How can we support you today?",
            modifier = Modifier.padding(horizontal = 24.dp),
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xFF4A148C),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        // --- ACTION CARDS ---
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ActionCard(
                title = "AI Chatbot",
                subtitle = "Talk to our supportive AI\ncompanion",
                icon = Icons.Default.Chat,
                bgColor = Color(0xFFE8EAF6),
                iconColor = Color(0xFF3F51B5),
                onClick = { navController.navigate("ai") }
            )
            ActionCard(
                title = "Mood Check-In",
                subtitle = "Track how you're\nfeeling today",
                icon = Icons.Default.Favorite,
                bgColor = Color(0xFFFCE4EC),
                iconColor = Color(0xFFE91E63),
                onClick = { navController.navigate("mood") }
            )
            ActionCard(
                title = "Self-Care",
                subtitle = "Meditation, breathing, and\njournaling",
                icon = Icons.Default.AutoAwesome,
                bgColor = Color(0xFFE1F5FE),
                iconColor = Color(0xFF0288D1),
                onClick = { navController.navigate("care") }
            )
            ActionCard(
                title = "Progress",
                subtitle = "View your wellness journey",
                icon = Icons.Default.ShowChart,
                bgColor = Color(0xFFE0F2F1),
                iconColor = Color(0xFF00897B),
                onClick = { navController.navigate("progress") }
            )
        }
    }
}

@Composable
fun StatCard(label: String, value: String, icon: ImageVector, unit: String? = null) {
    Card(
        modifier = Modifier
            .width(100.dp)
            .height(110.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.15f))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(icon, contentDescription = null, tint = Color(0xFFFFEB3B), modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.height(4.dp))
            Text(label, color = Color.Black, fontSize = 12.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(value, color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            if (unit != null) {
                Text(unit, color = Color.Black, fontSize = 10.sp)
            }
        }
    }
}

@Composable
fun ActionCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    bgColor: Color,
    iconColor: Color,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .shadow(4.dp, RoundedCornerShape(24.dp)),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = bgColor)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(64.dp),
                shape = RoundedCornerShape(16.dp),
                color = Color.White,
                shadowElevation = 2.dp
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(icon, contentDescription = null, tint = iconColor, modifier = Modifier.size(32.dp))
                }
            }
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(title, fontWeight = FontWeight.Bold, color = Color(0xFF4A148C), fontSize = 18.sp)
                Text(subtitle, fontSize = 14.sp, color = iconColor.copy(alpha = 0.8f), lineHeight = 18.sp)
            }
        }
    }
}
