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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedbackScreen(navController: NavController) {
    var feedback by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFFBFAFF))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // --- HEADER ---
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color(0xFF7B1FA2),
                    modifier = Modifier.size(28.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Feedback",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4A148C)
            )
            Text(
                text = "Help us improve Solace",
                fontSize = 16.sp,
                color = Color(0xFFAB47BC),
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // --- INPUT CARD ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(260.dp)
                .shadow(12.dp, RoundedCornerShape(32.dp)),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            OutlinedTextField(
                value = feedback,
                onValueChange = { feedback = it },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                placeholder = { 
                    Text(
                        "Share your thoughts, suggestions, or reports...",
                        color = Color.Gray.copy(alpha = 0.6f),
                        fontSize = 15.sp
                    ) 
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                textStyle = LocalTextStyle.current.copy(fontSize = 16.sp, color = Color.Black)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- DISCLAIMER CARD ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(2.dp, RoundedCornerShape(32.dp)),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFDE7)), // Light Yellow
            border = BorderStroke(1.dp, Color(0xFFFFF176))
        ) {
            Row(modifier = Modifier.padding(24.dp), verticalAlignment = Alignment.Top) {
                Icon(
                    Icons.Default.Info, 
                    contentDescription = null, 
                    tint = Color(0xFFF57F17), 
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = "Important Disclaimer",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF795548)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Solace is a supportive tool and is not a substitute for professional mental health care. If you're experiencing a mental health crisis, please contact emergency services or a crisis helpline.",
                        fontSize = 13.sp,
                        color = Color(0xFF8D6E63),
                        lineHeight = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // --- PRIVACY NOTICE ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(2.dp, RoundedCornerShape(32.dp)),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF3E5F5).copy(alpha = 0.5f))
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Text(
                    text = "Privacy Notice",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF7B1FA2)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Your feedback is anonymous and will be used solely to improve the app. We do not collect personally identifiable information through this form.",
                    fontSize = 13.sp,
                    color = Color(0xFFAB47BC),
                    lineHeight = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // --- SUBMIT BUTTON ---
        Button(
            onClick = { /* Submit logic */ navController.popBackStack() },
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
                            colors = listOf(Color(0xFF90CAF9), Color(0xFFE1BEE7)) // Light Blue to Light Purple
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Send, contentDescription = null, tint = Color.White, modifier = Modifier.size(24.dp))
                    Spacer(modifier = Modifier.width(12.dp))
                    Text("Submit Feedback", color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Back to Home",
            fontSize = 16.sp,
            color = Color(0xFFAB47BC),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable { navController.navigate("home") }
        )
        
        Spacer(modifier = Modifier.height(40.dp))
    }
}
