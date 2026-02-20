package com.simats.chatbot.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OTPScreen(navController: NavController) {
    var otpCode by remember { mutableStateOf(List(4) { "" }) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFFBFAFF))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // --- BACK BUTTON ---
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

        Spacer(modifier = Modifier.height(32.dp))

        // --- TITLE ---
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Verify Email",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4A148C)
            )
            Text(
                text = "We've sent a 4-digit code to your email",
                fontSize = 16.sp,
                color = Color(0xFFAB47BC),
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(64.dp))

        // --- OTP INPUT FIELDS ---
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
        ) {
            otpCode.forEachIndexed { index, code ->
                OTPDigitBox(
                    value = code,
                    onValueChange = { newValue ->
                        if (newValue.length <= 1) {
                            val newList = otpCode.toMutableList()
                            newList[index] = newValue
                            otpCode = newList
                        }
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(48.dp))

        // --- RESEND TEXT ---
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Didn't receive code? ",
                color = Color(0xFFAB47BC),
                fontSize = 15.sp
            )
            Text(
                text = "Resend",
                color = Color(0xFF7B1FA2),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { /* Resend logic */ }
            )
        }

        Spacer(modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.height(32.dp))

        // --- VERIFY BUTTON ---
        Button(
            onClick = {
                // Verification logic would go here
                navController.navigate("home") {
                    popUpTo("welcome") { inclusive = true }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .shadow(12.dp, RoundedCornerShape(32.dp)),
            shape = RoundedCornerShape(32.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(),
            enabled = otpCode.all { it.isNotEmpty() }
        ) {
            val alpha = if (otpCode.all { it.isNotEmpty() }) 1f else 0.5f
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
                    text = "Verify & Continue",
                    color = Color.Black.copy(alpha = if (alpha == 1f) 1f else 0.7f),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        
        Spacer(modifier = Modifier.height(40.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OTPDigitBox(
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .size(64.dp)
            .shadow(4.dp, RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            unfocusedBorderColor = Color(0xFFF3E5F5),
            focusedBorderColor = Color(0xFFAB47BC)
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        textStyle = LocalTextStyle.current.copy(
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    )
}
