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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MoodAnalyticsScreen(navController: NavController) {
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
                .shadow(12.dp, RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFAB47BC), // Purple
                            Color(0xFF42A5F5)  // Blue
                        )
                    )
                )
                .padding(24.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Black,
                        modifier = Modifier
                            .background(Color.White.copy(alpha = 0.2f), CircleShape)
                            .padding(6.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = "Mood Analytics",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = "Your wellness insights",
                        fontSize = 14.sp,
                        color = Color.Black.copy(alpha = 0.8f)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- TOP STATS ROW ---
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            StatsCard(
                modifier = Modifier.weight(1f),
                icon = Icons.Outlined.CalendarToday,
                value = "1",
                label = "Total Check-ins",
                color = Color(0xFFAB47BC),
                bg = Color(0xFFF3E5F5).copy(alpha = 0.5f)
            )
            StatsCard(
                modifier = Modifier.weight(1f),
                icon = Icons.Outlined.FavoriteBorder,
                value = "1",
                label = "This Week",
                color = Color(0xFF00C853),
                bg = Color(0xFFE8F5E9).copy(alpha = 0.5f)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- MOST COMMON MOOD ---
        Card(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp).shadow(6.dp, RoundedCornerShape(32.dp)),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Outlined.SentimentSatisfiedAlt, contentDescription = null, tint = Color(0xFFAB47BC), modifier = Modifier.size(24.dp))
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(text = "Most Common Mood", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4A148C))
                }
                Spacer(modifier = Modifier.height(16.dp))
                Surface(
                    color = Color(0xFFF3E5F5).copy(alpha = 0.3f),
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = "Okay", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color(0xFF7B1FA2))
                        Text(text = "Recorded 1 times (100% of entries)", fontSize = 13.sp, color = Color(0xFFAB47BC))
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- AVERAGE STRESS LEVEL ---
        Card(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp).shadow(6.dp, RoundedCornerShape(32.dp)),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Outlined.Bolt, contentDescription = null, tint = Color(0xFFFFB300), modifier = Modifier.size(24.dp))
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(text = "Average Stress Level", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4A148C))
                }
                Spacer(modifier = Modifier.height(16.dp))
                Surface(
                    color = Color(0xFFFFFDE7),
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(text = "5.0/10", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color(0xFFBF360C))
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Your stress is at a moderate level. Consider regular self-care.",
                            fontSize = 14.sp,
                            color = Color(0xFFE65100),
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- RECENT TREND ---
        Card(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp).shadow(6.dp, RoundedCornerShape(32.dp)),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Outlined.TrendingUp, contentDescription = null, tint = Color(0xFF00C853), modifier = Modifier.size(24.dp))
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(text = "Recent Trend", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4A148C))
                }
                Spacer(modifier = Modifier.height(16.dp))
                // Trend Placeholder
                Box(
                    modifier = Modifier.fillMaxWidth().height(100.dp).background(Color(0xFFFBFAFF), RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Mood Trend Chart Placeholder", color = Color.Gray.copy(alpha = 0.5f), fontSize = 14.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- PERSONALIZED INSIGHTS ---
        Card(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp).shadow(6.dp, RoundedCornerShape(32.dp)),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Outlined.Lightbulb, contentDescription = null, tint = Color(0xFFAB47BC), modifier = Modifier.size(24.dp))
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(text = "Personalized Insights", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4A148C))
                }
                Spacer(modifier = Modifier.height(20.dp))
                
                InsightItem(
                    text = "😊 Your stress management is working well! Your average stress level is below 5/10.",
                    bg = Color(0xFFE3F2FD),
                    accent = Color(0xFF2196F3)
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                InsightItem(
                    text = "💡 Check in more regularly to get better insights into your mood patterns. Try to track your mood at least once a day!",
                    bg = Color(0xFFFFFDE7),
                    accent = Color(0xFFFFB300)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- MOOD DISTRIBUTION ---
        Card(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp).shadow(6.dp, RoundedCornerShape(32.dp)),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Text(text = "Mood Distribution", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4A148C))
                Spacer(modifier = Modifier.height(20.dp))
                
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Okay", fontSize = 14.sp, color = Color(0xFF7B1FA2), modifier = Modifier.width(60.dp))
                    LinearProgressIndicator(
                        progress = 1f,
                        modifier = Modifier.weight(1f).height(8.dp).clip(CircleShape),
                        color = Color(0xFF42A5F5),
                        trackColor = Color(0xFFF3E5F5)
                    )
                    Text("1 x", fontSize = 14.sp, color = Color(0xFF7B1FA2), textAlign = TextAlign.End, modifier = Modifier.padding(start = 12.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(48.dp))

        // --- GET RECOMMENDATIONS BUTTON ---
        Button(
            onClick = { /* Recommendations logic */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
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
                Text("Get Recommendations", color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }
        
        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Composable
fun StatsCard(modifier: Modifier, icon: androidx.compose.ui.graphics.vector.ImageVector, value: String, label: String, color: Color, bg: Color) {
    Card(
        modifier = modifier.shadow(4.dp, RoundedCornerShape(24.dp)),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = bg)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Icon(icon, contentDescription = null, tint = color, modifier = Modifier.size(28.dp))
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = value, fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4A148C))
            Text(text = label, fontSize = 13.sp, color = color, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun InsightItem(text: String, bg: Color, accent: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(bg)
            .drawBehind {
                val strokeWidth = 12f
                drawLine(
                    color = accent,
                    start = androidx.compose.ui.geometry.Offset(0f, 0f),
                    end = androidx.compose.ui.geometry.Offset(0f, size.height),
                    strokeWidth = strokeWidth
                )
            }
            .padding(16.dp)
    ) {
        Text(
            text = text,
            fontSize = 13.sp,
            color = Color(0xFF4A148C),
            lineHeight = 18.sp,
            fontWeight = FontWeight.Medium
        )
    }
}
