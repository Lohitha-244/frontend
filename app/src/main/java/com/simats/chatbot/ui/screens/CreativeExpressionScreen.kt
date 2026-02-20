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
fun CreativeExpressionScreen(navController: NavController) {
    var brushSize by remember { mutableStateOf(8f) }
    var selectedColor by remember { mutableStateOf(Color(0xFF9C27B0)) }
    var isDrawing by remember { mutableStateOf(true) }

    val colors = listOf(
        Color(0xFF9C27B0), Color(0xFFE91E63), Color(0xFF2196F3),
        Color(0xFF4CAF50), Color(0xFFFFB300), Color(0xFFF44336),
        Color(0xFF00BCD4), Color(0xFF5C6BC0)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFFBFAFF))
    ) {
        // --- PINK-PURPLE GRADIENT HEADER ---
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(10.dp, RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFEC407A), // Pink
                            Color(0xFFAB47BC)  // Purple
                        )
                    )
                )
                .padding(24.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
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
                                text = "Creative Expression",
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = "Art therapy & mindful drawing",
                                fontSize = 13.sp,
                                color = Color.White.copy(alpha = 0.8f)
                            )
                        }
                    }
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Image, contentDescription = "Gallery", tint = Color.White)
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // --- PROMPT CARD ---
                Surface(
                    modifier = Modifier.fillMaxWidth().shadow(4.dp, RoundedCornerShape(20.dp)),
                    shape = RoundedCornerShape(20.dp),
                    color = Color.White.copy(alpha = 0.2f)
                ) {
                    Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("🌟", fontSize = 24.sp)
                        Text(
                            "Express what you're grateful for",
                            color = Color.White,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- DRAWING CANVAS ---
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .padding(horizontal = 24.dp)
                .shadow(8.dp, RoundedCornerShape(32.dp)),
            shape = RoundedCornerShape(32.dp),
            color = Color.White,
            border = BorderStroke(1.dp, Color(0xFFF3E5F5))
        ) {
            // Placeholder for drawing area
            Box(contentAlignment = Alignment.Center) {
                Text("Start drawing here...", color = Color.LightGray.copy(alpha = 0.5f))
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- STATS ROW ---
        Row(
            modifier = Modifier.padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CreativeStatBox("Strokes", "0", Modifier.weight(1f))
            CreativeStatBox("Creating", "0:17", Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- TOOLBAR ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .shadow(4.dp, RoundedCornerShape(32.dp)),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                // Color Palette
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Palette, contentDescription = null, tint = Color(0xFF7B1FA2), modifier = Modifier.size(18.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Colors", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF7B1FA2))
                }
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    colors.forEach { color ->
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                                .background(color)
                                .clickable { selectedColor = color }
                                .border(
                                    width = if (selectedColor == color) 2.dp else 0.dp,
                                    color = if (selectedColor == color) Color.White else Color.Transparent,
                                    shape = CircleShape
                                )
                                .shadow(if (selectedColor == color) 2.dp else 0.dp, CircleShape)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Mode Toggle
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Button(
                        onClick = { isDrawing = true },
                        modifier = Modifier.weight(1f).height(48.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isDrawing) Color(0xFFE91E63) else Color(0xFFF5F5F5)
                        )
                    ) {
                        Icon(Icons.Default.Brush, contentDescription = null, tint = if (isDrawing) Color.White else Color.Gray)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Draw", color = if (isDrawing) Color.White else Color.Gray)
                    }
                    Button(
                        onClick = { isDrawing = false },
                        modifier = Modifier.weight(1f).height(48.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (!isDrawing) Color(0xFF607D8B) else Color(0xFFF5F5F5)
                        )
                    ) {
                        Icon(Icons.Default.AutoFixNormal, contentDescription = null, tint = if (!isDrawing) Color.White else Color.Gray)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Erase", color = if (!isDrawing) Color.White else Color.Gray)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Brush Size
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Brush Size", fontSize = 13.sp, color = Color.Gray)
                    Text("${brushSize.toInt()}px", fontSize = 13.sp, color = Color(0xFF7B1FA2), fontWeight = FontWeight.Bold)
                }
                Slider(
                    value = brushSize,
                    onValueChange = { brushSize = it },
                    valueRange = 1f..50f,
                    colors = SliderDefaults.colors(
                        thumbColor = Color(0xFFAB47BC),
                        activeTrackColor = Color(0xFFE1BEE7)
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- CONTROL BUTTONS ---
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ControlIconButton(Icons.Default.Refresh, "Clear", Color(0xFFFF5252), Modifier.weight(1f))
            ControlIconButton(Icons.Default.FavoriteBorder, "Save", Color(0xFF42A5F5), Modifier.weight(1f))
            ControlIconButton(Icons.Default.Download, "Export", Color(0xFF00C853), Modifier.weight(1f))
            ControlIconButton(Icons.Default.SentimentVerySatisfied, "Done", Color(0xFFAB47BC), Modifier.weight(1f), onClick = { navController.popBackStack() })
        }

        Spacer(modifier = Modifier.height(32.dp))

        // --- REMEMBER TIP ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 40.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF3E5F5).copy(alpha = 0.5f))
        ) {
            Row(modifier = Modifier.padding(20.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.AutoAwesome, contentDescription = null, tint = Color(0xFFAB47BC), modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Remember: There's no right or wrong in art. Just express yourself freely!😊",
                    fontSize = 14.sp,
                    color = Color(0xFF7B1FA2),
                    lineHeight = 20.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun CreativeStatBox(label: String, value: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.height(64.dp).shadow(2.dp, RoundedCornerShape(20.dp)),
        shape = RoundedCornerShape(20.dp),
        color = Color(0xFFFCE4EC).copy(alpha = 0.5f)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = label, fontSize = 11.sp, color = Color(0xFFAB47BC).copy(alpha = 0.8f))
            Text(text = value, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF880E4F))
        }
    }
}

@Composable
fun ControlIconButton(icon: ImageVector, label: String, color: Color, modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    Button(
        onClick = onClick,
        modifier = modifier.height(72.dp),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color),
        contentPadding = PaddingValues()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(icon, contentDescription = label, tint = Color.White)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = label, fontSize = 12.sp, color = Color.White)
        }
    }
}
