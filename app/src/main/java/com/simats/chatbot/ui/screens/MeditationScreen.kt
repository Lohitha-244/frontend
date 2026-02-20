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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MeditationScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFFBFAFF))
    ) {
        // --- GRADIENT HEADER ---
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(10.dp, RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF9C27B0), // Purple
                            Color(0xFFE91E63)  // Pink
                        )
                    )
                )
                .padding(24.dp)
        ) {
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
                        text = "Guided Meditation",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        text = "Find your inner peace",
                        fontSize = 14.sp,
                        color = Color.White.copy(alpha = 0.8f)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // --- SUBTITLE ---
        Row(
            modifier = Modifier.padding(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Choose a meditation session",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4A148C)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(Icons.Default.Headset, contentDescription = null, tint = Color(0xFF7B61FF), modifier = Modifier.size(18.dp))
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Audio guided", fontSize = 12.sp, color = Color(0xFF7B61FF))
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- MEDITATION SESSIONS ---
        Column(
            modifier = Modifier.padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            MeditationSessionCard(
                title = "Morning Calm",
                description = "Energize your day with mindful awakening",
                icon = Icons.Default.WbSunny,
                bgColor = Color(0xFFFFFDE7),
                playButtonColors = listOf(Color(0xFFFFB300), Color(0xFFFF6D00)),
                bullets = listOf("Gratitude focus", "Energizing breath", "Positive intentions"),
                highlights = listOf("Boost energy", "Set positive tone", "Mental clarity"),
                duration = "5 min",
                bestTime = "Best: 6-9 AM",
                onClick = { navController.navigate("meditationPlayer") }
            )

            MeditationSessionCard(
                title = "Stress Relief",
                description = "Release tension with body-scan relaxation",
                icon = Icons.Default.Shield,
                bgColor = Color(0xFFE0F7FA),
                playButtonColors = listOf(Color(0xFF00B8D4), Color(0xFF00B0FF)),
                bullets = listOf("Body awareness", "Tension release", "Calming breath"),
                highlights = listOf("Lower cortisol", "Muscle relaxation", "Anxiety relief"),
                duration = "10 min",
                bestTime = "Best: Anytime",
                onClick = { navController.navigate("meditationPlayer") }
            )

            MeditationSessionCard(
                title = "Deep Relaxation",
                description = "Progressive muscle relaxation for complete rest",
                icon = Icons.Default.Waves,
                bgColor = Color(0xFFF3E5F5),
                playButtonColors = listOf(Color(0xFF7B1FA2), Color(0xFF7C4DFF)),
                bullets = listOf("Full body scan", "Deep breathing", "Visualization"),
                highlights = listOf("Full mind reset", "Physical recovery", "Emotional balance"),
                duration = "15 min",
                bestTime = "Best: Afternoon",
                onClick = { navController.navigate("meditationPlayer") }
            )

            MeditationSessionCard(
                title = "Sleep Preparation",
                description = "Wind down with sleep-inducing techniques",
                icon = Icons.Default.NightsStay,
                bgColor = Color(0xFFE8EAF6),
                playButtonColors = listOf(Color(0xFF3F51B5), Color(0xFF1A237E)),
                bullets = listOf("Body heaviness", "Slow breath", "Sleep imagery"),
                highlights = listOf("Fall asleep faster", "Deeper sleep", "Calm nervous system"),
                duration = "8 min",
                bestTime = "Best: 30 min before bed",
                onClick = { navController.navigate("meditationPlayer") }
            )

            // --- PRO TIP CARD ---
            Card(
                modifier = Modifier.fillMaxWidth().padding(bottom = 32.dp),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFCE4EC).copy(alpha = 0.5f))
            ) {
                Row(modifier = Modifier.padding(24.dp)) {
                    Icon(
                        Icons.Default.AutoAwesome,
                        contentDescription = null,
                        tint = Color(0xFFAB47BC),
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = "Pro Tip:",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF4A148C)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Each meditation uses different techniques. Try them at their recommended times for maximum benefit!",
                            fontSize = 14.sp,
                            color = Color(0xFF6A1B9A),
                            lineHeight = 20.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MeditationSessionCard(
    title: String,
    description: String,
    icon: ImageVector,
    bgColor: Color,
    playButtonColors: List<Color>,
    bullets: List<String>,
    highlights: List<String>,
    duration: String,
    bestTime: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(4.dp, RoundedCornerShape(32.dp)),
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(containerColor = bgColor)
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Surface(
                    modifier = Modifier.size(72.dp).shadow(2.dp, RoundedCornerShape(20.dp)),
                    shape = RoundedCornerShape(20.dp),
                    color = Color.White
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(icon, contentDescription = null, tint = playButtonColors[0], modifier = Modifier.size(32.dp))
                    }
                }

                Surface(
                    modifier = Modifier.size(56.dp).clickable { onClick() }.shadow(4.dp, CircleShape),
                    shape = CircleShape,
                    color = Color.Transparent
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(brush = Brush.radialGradient(playButtonColors)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Default.PlayArrow, contentDescription = "Play", tint = Color.White, modifier = Modifier.size(28.dp))
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = title, fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4A148C))
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = description, fontSize = 16.sp, color = Color(0xFF7B61FF))

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = bullets.joinToString(" • "),
                fontSize = 14.sp,
                color = Color(0xFFAB47BC)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                highlights.forEach { highlight ->
                    Row(
                        modifier = Modifier
                            .background(Color.White.copy(alpha = 0.5f), RoundedCornerShape(12.dp))
                            .padding(horizontal = 12.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.Check, contentDescription = null, tint = Color(0xFF7B61FF), modifier = Modifier.size(14.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = highlight, fontSize = 13.sp, color = Color(0xFF4A148C))
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Outlined.AccessTime, contentDescription = null, tint = Color(0xFF7B61FF), modifier = Modifier.size(18.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = duration, fontSize = 13.sp, color = Color(0xFF7B61FF))
                Spacer(modifier = Modifier.width(24.dp))
                Icon(Icons.Outlined.WatchLater, contentDescription = null, tint = Color(0xFFAB47BC).copy(alpha = 0.6f), modifier = Modifier.size(18.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = bestTime, fontSize = 13.sp, color = Color(0xFFAB47BC))
            }
        }
    }
}
