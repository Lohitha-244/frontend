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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun CareScreen(navController: NavController) {
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
                            Color(0xFF42A5F5), // Light Blue
                            Color(0xFF7B61FF)  // Purple
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
                        tint = Color.Black,
                        modifier = Modifier
                            .size(32.dp)
                            .background(Color.White.copy(alpha = 0.2f), CircleShape)
                            .padding(4.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Your Progress",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- SUBTITLE ---
        Text(
            text = "Choose an activity to nurture your well-being",
            fontSize = 16.sp,
            color = Color(0xFF7B61FF),
            modifier = Modifier.padding(horizontal = 24.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // --- FEATURED AI COMPANION CARD ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .shadow(8.dp, RoundedCornerShape(24.dp)),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF3E5F5))
        ) {
            Row(
                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .shadow(4.dp, RoundedCornerShape(20.dp))
                        .clip(RoundedCornerShape(20.dp))
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(Color(0xFFEC407A), Color(0xFFAB47BC))
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.ChatBubbleOutline, contentDescription = null, tint = Color.Black, modifier = Modifier.size(32.dp))
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "AI Support Companion",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF4A148C)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Surface(
                            color = Color(0xFFAB47BC),
                            shape = CircleShape
                        ) {
                            Text(
                                "New",
                                color = Color.Black,
                                fontSize = 10.sp,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                            )
                        }
                    }
                    Text(
                        "Chat with mood-aware AI\nfor personalized support",
                        fontSize = 13.sp,
                        color = Color(0xFFAB47BC)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // --- SECTION: MINDFULNESS & RELAXATION ---
        CategoryHeader("MINDFULNESS & RELAXATION")
        CareActionCardSmall(
            title = "Meditation",
            subtitle = "Guided sessions for inner peace",
            icon = Icons.Default.AutoAwesome,
            bgColor = Color(0xFFFCE4EC),
            iconColor = Color(0xFFAB47BC),
            onClick = { navController.navigate("meditation") }
        )
        CareActionCardSmall(
            title = "Breathing Exercises",
            subtitle = "Calm your nervous system instantly",
            icon = Icons.Default.Air,
            bgColor = Color(0xFFE0F7FA),
            iconColor = Color(0xFF0288D1),
            onClick = { navController.navigate("breathing") }
        )
        CareActionCardSmall(
            title = "Nature Sounds",
            subtitle = "Mix & match ambient soundscapes",
            icon = Icons.Default.Eco,
            bgColor = Color(0xFFE8F5E9),
            iconColor = Color(0xFF43A047),
            onClick = { navController.navigate("soundscape") }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // --- SECTION: EXPRESSION & REFLECTION ---
        CategoryHeader("EXPRESSION & REFLECTION")
        CareActionCardSmall(
            title = "Journaling",
            subtitle = "Process your thoughts & emotions",
            icon = Icons.Default.MenuBook,
            bgColor = Color(0xFFE8F5E9),
            iconColor = Color(0xFF1B5E20),
            onClick = { navController.navigate("journal") }
        )
        CareActionCardSmall(
            title = "Gratitude Practice",
            subtitle = "Count your daily blessings",
            icon = Icons.Default.FavoriteBorder,
            bgColor = Color(0xFFFFF9C4),
            iconColor = Color(0xFFF4511E),
            onClick = { navController.navigate("gratitude") }
        )
        CareActionCardSmall(
            title = "Creative Expression",
            subtitle = "Art therapy & mindful drawing",
            icon = Icons.Default.Palette,
            bgColor = Color(0xFFFFEBEE),
            iconColor = Color(0xFFD81B60),
            onClick = { navController.navigate("creative") }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // --- SECTION: BODY & MIND CONNECTION ---
        CategoryHeader("BODY & MIND CONNECTION")
        CareActionCardSmall(
            title = "Body Scan & Relaxation",
            subtitle = "Progressive muscle relaxation",
            icon = Icons.Default.SelfImprovement,
            bgColor = Color(0xFFF3E5F5),
            iconColor = Color(0xFF7B1FA2),
            onClick = { navController.navigate("bodyscan") }
        )
        CareActionCardSmall(
            title = "Music Therapy",
            subtitle = "Mood-enhancing soundscapes",
            icon = Icons.Default.MusicNote,
            bgColor = Color(0xFFE3F2FD),
            iconColor = Color(0xFF0277BD),
            onClick = { navController.navigate("music") }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // --- SECTION: POSITIVE MINDSET ---
        CategoryHeader("POSITIVE MINDSET")
        CareActionCardSmall(
            title = "Positive Affirmations",
            subtitle = "Daily empowering messages",
            icon = Icons.Default.SentimentVerySatisfied,
            bgColor = Color(0xFFFFF9C4),
            iconColor = Color(0xFFE65100),
            onClick = { navController.navigate("affirmations") }
        )
        CareActionCardSmall(
            title = "Track Your Progress",
            subtitle = "See your mental health journey",
            icon = Icons.Default.TrendingUp,
            bgColor = Color(0xFFE3F2FD),
            iconColor = Color(0xFF3F51B5),
            onClick = { navController.navigate("progress") }
        )

        Spacer(modifier = Modifier.height(40.dp))

        // --- TIP SECTION ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 24.dp),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF3E5F5).copy(alpha = 0.5f))
        ) {
            Column(
                modifier = Modifier.padding(24.dp).fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "💡 Tip: Practicing just 10 minutes of self-\ncare daily can significantly\nreduce stress and improve\noverall well-being",
                    fontSize = 16.sp,
                    color = Color(0xFF7B1FA2),
                    lineHeight = 22.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun CategoryHeader(text: String) {
    Text(
        text = text,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFAB47BC).copy(alpha = 0.8f),
        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp)
    )
}

@Composable
fun CareActionCardSmall(
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
            .padding(horizontal = 24.dp, vertical = 8.dp)
            .clickable { onClick() }
            .shadow(2.dp, RoundedCornerShape(24.dp)),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(56.dp).shadow(2.dp, RoundedCornerShape(16.dp)),
                shape = RoundedCornerShape(16.dp),
                color = Color.White
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(icon, contentDescription = null, tint = iconColor, modifier = Modifier.size(32.dp))
                }
            }
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(title, fontWeight = FontWeight.Bold, color = Color(0xFF4A148C), fontSize = 17.sp)
                Text(subtitle, fontSize = 13.sp, color = Color(0xFF7B61FF))
            }
        }
    }
}
