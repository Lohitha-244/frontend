package com.simats.chatbot.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun GratitudeScreen(navController: NavController) {
    var gratitudeText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFFFFDE7).copy(alpha = 0.3f))
    ) {
        // --- YELLOW TO PINK GRADIENT HEADER ---
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(10.dp, RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFFFB300), // Yellow/Orange
                            Color(0xFFE91E63)  // Pink
                        )
                    )
                )
                .padding(24.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White,
                            modifier = Modifier
                                .background(Color.White.copy(alpha = 0.2f), CircleShape)
                                .padding(4.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = "Gratitude Practice",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = "Count your blessings",
                            fontSize = 14.sp,
                            color = Color.White.copy(alpha = 0.8f)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // --- STATS ROW ---
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    StatBox("Today", "0", Modifier.weight(1f))
                    StatBox("Total", "0", Modifier.weight(1f))
                    StatBox("Streak", "3🔥", Modifier.weight(1f))
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- TODAY'S PROMPT ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .shadow(4.dp, RoundedCornerShape(24.dp)),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF9C4))
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.AutoAwesome, contentDescription = null, tint = Color(0xFFF57C00), modifier = Modifier.size(18.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "TODAY'S PROMPT",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFF57C00)
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "What do you appreciate about yourself?",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF5D4037)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- MAIN INPUT AREA ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .shadow(8.dp, RoundedCornerShape(32.dp)),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.FavoriteBorder, contentDescription = null, tint = Color(0xFFD81B60), modifier = Modifier.size(24.dp))
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "What are you grateful for?",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFD81B60)
                    )
                }
                
                Spacer(modifier = Modifier.height(20.dp))

                // --- CATEGORY GRID ---
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        GratitudeCategory("People", "👥", Color(0xFFFCE4EC), Color(0xFF880E4F), Modifier.weight(1f))
                        GratitudeCategory("Moments", "✨", Color(0xFFF3E5F5), Color(0xFF4A148C), Modifier.weight(1f))
                        GratitudeCategory("Things", "🎁", Color(0xFFE3F2FD), Color(0xFF1A237E), Modifier.weight(1f))
                    }
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        GratitudeCategory("Self", "💪", Color(0xFFE8F5E9), Color(0xFF1B5E20), Modifier.weight(1f))
                        GratitudeCategory("Nature", "🍃", Color(0xFFE0F2F1), Color(0xFF004D40), Modifier.weight(1f))
                        GratitudeCategory("Opportunities", "🚀", Color(0xFFFFF3E0), Color(0xFFE65100), Modifier.weight(1f))
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // --- INPUT FIELD ---
                OutlinedTextField(
                    value = gratitudeText,
                    onValueChange = { gratitudeText = it },
                    placeholder = { Text("I'm grateful for...", color = Color.LightGray) },
                    modifier = Modifier.fillMaxWidth().height(120.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFFFFB300),
                        unfocusedBorderColor = Color(0xFFFFE082)
                    )
                )

                Spacer(modifier = Modifier.height(24.dp))

                // --- ADD BUTTON ---
                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .shadow(4.dp, RoundedCornerShape(20.dp)),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(Color(0xFFFFB74D), Color(0xFFF06292))
                                )
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Add, contentDescription = null, tint = Color.White)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Add Gratitude", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // --- GRATITUDE BENEFITS SECTION ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .shadow(2.dp, RoundedCornerShape(32.dp)),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFCE4EC).copy(alpha = 0.3f))
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.AutoAwesome, contentDescription = null, tint = Color(0xFFAB47BC))
                    Spacer(modifier = Modifier.width(12.dp))
                    Text("Gratitude Benefits", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF7B1FA2))
                }
                Spacer(modifier = Modifier.height(20.dp))
                BenefitRow(Icons.Default.FavoriteBorder, "Better Sleep:", "Grateful thoughts before bed improve sleep quality")
                BenefitRow(Icons.Default.TrendingUp, "More Happiness:", "Regular practice increases overall life satisfaction")
                BenefitRow(Icons.Default.StarOutline, "Stronger Relationships:", "Expressing gratitude deepens connections")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- PRO TIP ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 32.dp)
                .shadow(2.dp, RoundedCornerShape(24.dp)),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF9C4).copy(alpha = 0.8f))
        ) {
            Row(modifier = Modifier.padding(20.dp), verticalAlignment = Alignment.Top) {
                Text("💡", fontSize = 18.sp)
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Pro Tip: Try listing 3 things you're grateful for every morning. Your brain will start naturally looking for more good things throughout the day!",
                    fontSize = 14.sp,
                    color = Color(0xFF8D6E63),
                    lineHeight = 20.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}

@Composable
fun StatBox(label: String, value: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.height(64.dp).shadow(2.dp, RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        color = Color.White.copy(alpha = 0.3f)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = label, fontSize = 11.sp, color = Color.White.copy(alpha = 0.8f))
            Text(text = value, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
    }
}

@Composable
fun GratitudeCategory(name: String, emoji: String, bgColor: Color, textColor: Color, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.height(64.dp).shadow(1.dp, RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        color = bgColor
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = emoji, fontSize = 20.sp)
            Text(text = name, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = textColor)
        }
    }
}

@Composable
fun BenefitRow(icon: ImageVector, title: String, description: String) {
    Row(modifier = Modifier.padding(vertical = 8.dp), verticalAlignment = Alignment.Top) {
        Icon(icon, contentDescription = null, tint = Color(0xFFE91E63), modifier = Modifier.size(18.dp).padding(top = 2.dp))
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(
                text = title,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF7B1FA2)
            )
            Text(
                text = description,
                fontSize = 13.sp,
                color = Color(0xFFAB47BC)
            )
        }
    }
}
