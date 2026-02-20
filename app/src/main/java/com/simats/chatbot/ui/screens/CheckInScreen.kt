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

@Composable
fun CheckInScreen(navController: NavController) {
    var energy by remember { mutableStateOf("") }
    var sleep by remember { mutableStateOf("") }
    var tension by remember { mutableStateOf("") }

    val optionsEnergy = listOf("Very Low", "Low", "Moderate", "High", "Very High")
    val optionsSleep = listOf("Very Poorly", "Poorly", "Okay", "Well", "Very Well")
    val optionsTension = listOf("A Lot", "Some", "A Little", "Not Much", "None")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFFBFAFF))
            .padding(24.dp)
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
                text = "A few quick questions",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4A148C)
            )
            Text(
                text = "Help us understand you better",
                fontSize = 16.sp,
                color = Color(0xFFAB47BC),
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // --- Q1 CARD ---
        QuestionCard(
            questionNumber = "Q1",
            questionText = "How would you rate your energy level today?",
            options = optionsEnergy,
            selectedOption = energy,
            onOptionSelected = { energy = it }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // --- Q2 CARD ---
        QuestionCard(
            questionNumber = "Q2",
            questionText = "How well did you sleep last night?",
            options = optionsSleep,
            selectedOption = sleep,
            onOptionSelected = { sleep = it }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // --- Q3 CARD ---
        QuestionCard(
            questionNumber = "Q3",
            questionText = "Are you experiencing any physical tension?",
            options = optionsTension,
            selectedOption = tension,
            onOptionSelected = { tension = it }
        )

        Spacer(modifier = Modifier.height(48.dp))

        // --- COMPLETE CHECK-IN BUTTON ---
        Button(
            onClick = { navController.navigate("checkinComplete") },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .shadow(12.dp, RoundedCornerShape(32.dp)),
            shape = RoundedCornerShape(32.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(),
            enabled = energy.isNotEmpty() && sleep.isNotEmpty() && tension.isNotEmpty()
        ) {
            val alpha = if (energy.isNotEmpty() && sleep.isNotEmpty() && tension.isNotEmpty()) 1f else 0.5f
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFF90CAF9).copy(alpha = alpha), 
                                Color(0xFFE1BEE7).copy(alpha = alpha)
                            )
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Complete Check-In",
                    color = Color.White.copy(alpha = if (alpha == 1f) 1f else 0.7f),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        
        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Composable
fun QuestionCard(
    questionNumber: String,
    questionText: String,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(32.dp)),
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Row(verticalAlignment = Alignment.Top) {
                Text(
                    text = questionNumber,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFAB47BC)
                )
                Text(
                    text = questionText,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF7B1FA2),
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
            
            Spacer(modifier = Modifier.height(20.dp))
            
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                options.forEach { option ->
                    val isSelected = selectedOption == option
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .clickable { onOptionSelected(option) }
                            .shadow(if (isSelected) 2.dp else 0.dp, RoundedCornerShape(16.dp)),
                        shape = RoundedCornerShape(16.dp),
                        color = if (isSelected) Color(0xFFF3E5F5) else Color(0xFFFBFAFF).copy(alpha = 0.5f),
                        border = if (isSelected) null else BorderStroke(1.dp, Color(0xFFF3E5F5))
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                text = option,
                                fontSize = 16.sp,
                                color = if (isSelected) Color(0xFF7B1FA2) else Color(0xFFAB47BC),
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                            )
                        }
                    }
                }
            }
        }
    }
}
