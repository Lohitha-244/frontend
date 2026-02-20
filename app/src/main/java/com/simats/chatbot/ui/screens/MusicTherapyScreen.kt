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
fun MusicTherapyScreen(navController: NavController) {
    var selectedMood by remember { mutableStateOf("Calm") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFFBFAFF))
    ) {
        // --- PINK GRADIENT HEADER ---
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(10.dp, RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFBA68C8), // Purple/Lavender
                            Color(0xFFF06292)  // Pink
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
                            text = "Music Therapy",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = "Mood-enhancing soundscapes",
                            fontSize = 14.sp,
                            color = Color.White.copy(alpha = 0.8f)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // --- STATS PILL ---
                Surface(
                    color = Color.White.copy(alpha = 0.2f),
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Outlined.AccessTime, contentDescription = null, tint = Color.White, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Listening: 0:00", color = Color.White, fontSize = 14.sp)
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.TrendingUp, contentDescription = null, tint = Color.White, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("18 tracks", color = Color.White, fontSize = 14.sp)
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // --- MOOD SELECTOR SECTION ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .shadow(4.dp, RoundedCornerShape(32.dp)),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Text(
                    text = "Choose Your Mood",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF7B1FA2)
                )
                Spacer(modifier = Modifier.height(20.dp))
                
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    MoodSelectorBox("Calm", "😌", Color(0xFF42A5F5), selectedMood == "Calm", Modifier.weight(1f)) { selectedMood = "Calm" }
                    MoodSelectorBox("Happy", "😊", Color(0xFFFFCA28), selectedMood == "Happy", Modifier.weight(1f)) { selectedMood = "Happy" }
                    MoodSelectorBox("Focus", "🎯", Color(0xFFEF5350), selectedMood == "Focus", Modifier.weight(1f)) { selectedMood = "Focus" }
                }
                Spacer(modifier = Modifier.height(12.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    MoodSelectorBox("Energize", "⚡", Color(0xFFFF7043), selectedMood == "Energize", Modifier.weight(1f)) { selectedMood = "Energize" }
                    MoodSelectorBox("Sleep", "😴", Color(0xFF7986CB), selectedMood == "Sleep", Modifier.weight(1f)) { selectedMood = "Sleep" }
                    MoodSelectorBox("Meditative", "🧘", Color(0xFFD4E157), selectedMood == "Meditative", Modifier.weight(1f)) { selectedMood = "Meditative" }
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // --- TRACK LIST SECTION ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .shadow(4.dp, RoundedCornerShape(32.dp)),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Text(
                    text = "😌 Calm Track",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF7B1FA2)
                )
                Spacer(modifier = Modifier.height(20.dp))
                
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    MusicTrackItem("Ocean Breeze", "Gentle waves and soft\nmelodies • 60 BPM • 3:00", "🌊")
                    MusicTrackItem("Mountain Peace", "Serene mountain soundscapes\n• 55 BPM • 4:00", "🏔️")
                    MusicTrackItem("Forest Whisper", "Nature sounds with calming\ntones • 58 BPM • 3:20", "🌲")
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // --- INFO CARD ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 40.dp),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF3E5F5).copy(alpha = 0.5f))
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.MusicNote, contentDescription = null, tint = Color(0xFF7B1FA2))
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(text = "Music Therapy:", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF7B1FA2))
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Research shows that listening to music can reduce anxiety, improve mood, and enhance focus. Choose music that matches your desired emotional state!",
                    fontSize = 14.sp,
                    color = Color(0xFFAB47BC),
                    lineHeight = 22.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun MoodSelectorBox(label: String, emoji: String, color: Color, isSelected: Boolean, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Surface(
        modifier = modifier
            .height(90.dp)
            .clickable { onClick() }
            .shadow(if (isSelected) 8.dp else 1.dp, RoundedCornerShape(20.dp)),
        shape = RoundedCornerShape(20.dp),
        color = if (isSelected) color else Color(0xFFF3E5F5).copy(alpha = 0.3f),
        border = if (isSelected) null else BorderStroke(1.dp, Color(0xFFF3E5F5))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = emoji, fontSize = 28.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = label,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = if (isSelected) Color.White else Color(0xFFAB47BC)
            )
        }
    }
}

@Composable
fun MusicTrackItem(title: String, subtitle: String, icon: String) {
    Surface(
        modifier = Modifier.fillMaxWidth().height(100.dp),
        shape = RoundedCornerShape(24.dp),
        color = Color(0xFFF3E5F5).copy(alpha = 0.3f)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(48.dp),
                shape = RoundedCornerShape(12.dp),
                color = Color.White
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(icon, fontSize = 24.sp)
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFF7B1FA2))
                Text(text = subtitle, fontSize = 12.sp, color = Color(0xFFAB47BC), lineHeight = 16.sp)
            }
        }
    }
}
