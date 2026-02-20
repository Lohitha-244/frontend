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
fun SettingsScreen(navController: NavController) {
    var autoSpeak by remember { mutableStateOf(false) }
    var voiceInput by remember { mutableStateOf(true) }
    var highContrast by remember { mutableStateOf(false) }
    var dyslexiaFont by remember { mutableStateOf(false) }
    var iconOnlyNav by remember { mutableStateOf(false) }
    var fontSize by remember { mutableStateOf("M") }
    var darkMode by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFFBFAFF))
    ) {
        // --- PURPLE-BLUE GRADIENT HEADER ---
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(10.dp, RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
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
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Black,
                        modifier = Modifier
                            .background(Color.White.copy(alpha = 0.2f), CircleShape)
                            .padding(4.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Settings",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // --- ACCESSIBILITY SECTION ---
        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Accessibility, contentDescription = null, tint = Color(0xFF7B1FA2), modifier = Modifier.size(24.dp))
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Accessibility",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF7B1FA2)
                )
            }
            
            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier.fillMaxWidth().shadow(4.dp, RoundedCornerShape(32.dp)),
                shape = RoundedCornerShape(32.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    SettingsToggleItem(
                        icon = Icons.Outlined.VolumeUp,
                        title = "Auto-Speak AI Responses",
                        subtitle = "AI will speak responses aloud",
                        checked = autoSpeak,
                        onCheckedChange = { autoSpeak = it }
                    )
                    SettingsToggleItem(
                        icon = Icons.Default.MicNone,
                        title = "Voice Input (Microphone)",
                        subtitle = "Voice input enabled",
                        iconSubtitle = "🎤 ",
                        checked = voiceInput,
                        onCheckedChange = { voiceInput = it },
                        activeColor = Color(0xFFAB47BC)
                    )
                    SettingsToggleItem(
                        icon = Icons.Outlined.Visibility,
                        title = "High Contrast Mode",
                        subtitle = "Enhance visibility",
                        checked = highContrast,
                        onCheckedChange = { highContrast = it }
                    )
                    SettingsToggleItem(
                        icon = Icons.Default.TextFields,
                        title = "Dyslexia-Friendly Font",
                        subtitle = "Easier to read",
                        checked = dyslexiaFont,
                        onCheckedChange = { dyslexiaFont = it }
                    )
                    SettingsToggleItem(
                        icon = Icons.Default.Palette,
                        title = "Icon-Only Navigation",
                        subtitle = "No text, just emojis & icons",
                        checked = iconOnlyNav,
                        onCheckedChange = { iconOnlyNav = it }
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.TextFields, contentDescription = null, tint = Color(0xFFAB47BC), modifier = Modifier.size(20.dp))
                        Spacer(modifier = Modifier.width(12.dp))
                        Text("Font Size", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4A148C))
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        FontSizeButton("S", fontSize == "S", Modifier.weight(1f)) { fontSize = "S" }
                        FontSizeButton("M", fontSize == "M", Modifier.weight(1f)) { fontSize = "M" }
                        FontSizeButton("L", fontSize == "L", Modifier.weight(1f)) { fontSize = "L" }
                        FontSizeButton("E", fontSize == "E", Modifier.weight(1f)) { fontSize = "E" }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // --- LANGUAGE SECTION ---
        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Language, contentDescription = null, tint = Color(0xFF7B1FA2), modifier = Modifier.size(24.dp))
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Language",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF7B1FA2)
                )
            }
            
            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier.fillMaxWidth().shadow(4.dp, RoundedCornerShape(32.dp)),
                shape = RoundedCornerShape(32.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(24.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Public, contentDescription = null, tint = Color(0xFF7B1FA2), modifier = Modifier.size(20.dp))
                        Spacer(modifier = Modifier.width(12.dp))
                        Text("App Language", fontSize = 18.sp, fontWeight = FontWeight.Medium, color = Color(0xFF4A148C))
                    }
                    
                    Spacer(modifier = Modifier.height(20.dp))
                    
                    LanguageItem("English", "🇺🇸", true)
                    LanguageItem("Español", "🇪🇸", false)
                    LanguageItem("Français", "🇫🇷", false)
                    LanguageItem("Deutsch", "🇩🇪", false)
                    
                    Spacer(modifier = Modifier.height(12.dp))
                    
                    Text(
                        text = "See all 20+ languages →",
                        fontSize = 14.sp,
                        color = Color(0xFFAB47BC).copy(alpha = 0.8f),
                        modifier = Modifier.fillMaxWidth().clickable { },
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // --- APPEARANCE SECTION ---
        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.DarkMode, contentDescription = null, tint = Color(0xFF7B1FA2), modifier = Modifier.size(24.dp))
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Appearance",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF7B1FA2)
                )
            }
            
            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier.fillMaxWidth().shadow(4.dp, RoundedCornerShape(32.dp)),
                shape = RoundedCornerShape(32.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(24.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text("Dark Mode", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4A148C))
                            Text("Reduce eye strain", fontSize = 13.sp, color = Color(0xFFAB47BC))
                        }
                        Switch(
                            checked = darkMode,
                            onCheckedChange = { darkMode = it },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color.White,
                                checkedTrackColor = Color(0xFFAB47BC),
                                uncheckedThumbColor = Color.White,
                                uncheckedTrackColor = Color(0xFFE0E0E0)
                            )
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // --- ACCESSIBILITY FIRST INFO CARD ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .shadow(2.dp, RoundedCornerShape(32.dp)),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF3E5F5).copy(alpha = 0.5f))
        ) {
            Row(modifier = Modifier.padding(24.dp), verticalAlignment = Alignment.Top) {
                Icon(Icons.Default.AccessibilityNew, contentDescription = null, tint = Color(0xFF1976D2), modifier = Modifier.size(24.dp))
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Accessibility First: This app is designed for everyone, including users with visual, hearing, or reading challenges. All features work with screen readers and voice commands.",
                    fontSize = 14.sp,
                    color = Color(0xFF7B1FA2),
                    lineHeight = 22.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Start
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- OTHER OPTIONS ---
        Column(modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            SimpleSettingsCard("Privacy & Data", "Manage your data") { navController.navigate("privacy") }
            SimpleSettingsCard("Send Feedback", "Help us improve") { /* Feedback logic */ }
        }

        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Composable
fun SettingsToggleItem(
    icon: ImageVector,
    title: String,
    subtitle: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    iconSubtitle: String = "",
    activeColor: Color = Color(0xFFAB47BC)
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
            Icon(icon, contentDescription = null, tint = Color(0xFF7B1FA2), modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = title, fontSize = 17.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4A148C))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    if (iconSubtitle.isNotEmpty()) {
                        Text(text = iconSubtitle, fontSize = 13.sp)
                    }
                    Text(text = subtitle, fontSize = 13.sp, color = Color(0xFFAB47BC))
                }
            }
        }
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                checkedTrackColor = activeColor,
                uncheckedThumbColor = Color.White,
                uncheckedTrackColor = Color(0xFFE0E0E0)
            )
        )
    }
}

@Composable
fun FontSizeButton(label: String, isSelected: Boolean, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Surface(
        modifier = modifier.height(56.dp).clickable { onClick() }.shadow(if (isSelected) 4.dp else 1.dp, RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        color = if (isSelected) Color(0xFFAB47BC) else Color(0xFFF3E5F5).copy(alpha = 0.3f)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = label,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = if (isSelected) Color.Black else Color(0xFF7B1FA2)
            )
        }
    }
}

@Composable
fun LanguageItem(name: String, flag: String, isSelected: Boolean) {
    Surface(
        modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp).height(56.dp).shadow(if (isSelected) 4.dp else 1.dp, RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        color = if (isSelected) Color(0xFFAB47BC) else Color(0xFFF3E5F5).copy(alpha = 0.3f)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = flag, fontSize = 24.sp)
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = name,
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                color = if (isSelected) Color.Black else Color(0xFF4A148C)
            )
        }
    }
}

@Composable
fun SimpleSettingsCard(title: String, subtitle: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().height(80.dp).clickable { onClick() }.shadow(2.dp, RoundedCornerShape(24.dp)),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4A148C))
            Text(text = subtitle, fontSize = 13.sp, color = Color(0xFFAB47BC))
        }
    }
}
