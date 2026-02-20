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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavController) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

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

        Spacer(modifier = Modifier.height(16.dp))

        // --- TITLE ---
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Create Account",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4A148C)
            )
            Text(
                text = "Begin your journey to better mental health",
                fontSize = 16.sp,
                color = Color(0xFFAB47BC),
                fontWeight = FontWeight.Medium
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // --- INPUT FIELDS ---
        SignUpTextField(
            value = fullName,
            onValueChange = { fullName = it },
            placeholder = "Full Name",
            icon = Icons.Outlined.Person
        )

        Spacer(modifier = Modifier.height(20.dp))

        SignUpTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = "Email",
            icon = Icons.Outlined.Email
        )

        Spacer(modifier = Modifier.height(20.dp))

        SignUpTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = "Password (min. 6 characters)",
            icon = Icons.Outlined.Lock,
            isPassword = true,
            passwordVisible = passwordVisible,
            onTogglePassword = { passwordVisible = !passwordVisible }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // --- TERMS & PRIVACY CARD ---
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(2.dp, RoundedCornerShape(24.dp)),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF3E5F5).copy(alpha = 0.3f)),
            border = BorderStroke(1.dp, Color(0xFFF3E5F5))
        ) {
            Box(modifier = Modifier.padding(20.dp)) {
                val annotatedString = buildAnnotatedString {
                    append("I agree to the ")
                    withStyle(style = SpanStyle(
                        color = Color(0xFF7B1FA2), 
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    )) {
                        append("Terms of Service")
                    }
                    append(" and ")
                    withStyle(style = SpanStyle(
                        color = Color(0xFF7B1FA2), 
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    )) {
                        append("Privacy Policy")
                    }
                    append(" . I understand this app is for support, not professional medical advice.")
                }
                Text(
                    text = annotatedString,
                    fontSize = 14.sp,
                    color = Color(0xFFAB47BC),
                    lineHeight = 20.sp,
                    textAlign = TextAlign.Start
                )
            }
        }

        Spacer(modifier = Modifier.height(48.dp))
        Spacer(modifier = Modifier.weight(1f))

        // --- CREATE ACCOUNT BUTTON ---
        Button(
            onClick = { navController.navigate("otp") },
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
                            colors = listOf(Color(0xFF90CAF9), Color(0xFFE1BEE7))
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text("Create Account", color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- SIGN IN LINK ---
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Already have an account? ",
                color = Color(0xFFAB47BC),
                fontSize = 15.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Login",
                color = Color(0xFF7B1FA2),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable { navController.navigate("login") }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    isPassword: Boolean = false,
    passwordVisible: Boolean = false,
    onTogglePassword: () -> Unit = {}
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholder, color = Color.Gray.copy(alpha = 0.6f)) },
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color(0xFFAB47BC),
                modifier = Modifier.size(24.dp)
            )
        },
        trailingIcon = {
            if (isPassword) {
                IconButton(onClick = onTogglePassword) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = "Toggle Password",
                        tint = Color(0xFFAB47BC),
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
        shape = RoundedCornerShape(20.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            focusedContainerColor = Color(0xFFF3E5F5).copy(alpha = 0.1f),
            unfocusedContainerColor = Color(0xFFF3E5F5).copy(alpha = 0.1f),
            unfocusedBorderColor = Color(0xFFF3E5F5),
            focusedBorderColor = Color(0xFFAB47BC).copy(alpha = 0.5f),
            cursorColor = Color.Black
        ),
        visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
        singleLine = true
    )
}
