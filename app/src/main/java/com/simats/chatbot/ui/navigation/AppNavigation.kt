package com.simats.chatbot.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.simats.chatbot.ui.screens.*
import com.simats.chatbot.ui.WelcomeScreen

@Composable
fun AppNavigation(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = "welcome",
        modifier = Modifier.padding(paddingValues)
    ) {
        composable("welcome") {
            WelcomeScreen(onGetStarted = {
                navController.navigate("login")
            })
        }

        composable("login") { LoginScreen(navController) }
        composable("signup") { SignUpScreen(navController) }
        composable("otp") { OTPScreen(navController) }

        // Main Tabs
        composable("home") { HomeScreen(navController) }
        composable("mood") { MoodScreen(navController) }
        composable("care") { CareScreen(navController) }
        composable("progress") { ProgressScreen(navController) }
        composable("profile") { ProfileScreen(navController) }

        // Phase 2: Mood & Check-in Flow
        composable("checkin") { CheckInScreen(navController) }
        composable("checkinComplete") { CheckInCompleteScreen(navController) }
        composable("analytics") { MoodAnalyticsScreen(navController) }
        composable("history") { MoodHistoryScreen(navController) }

        // Phase 3: Care Features
        composable("meditation") { MeditationScreen(navController) }
        composable("meditationPlayer") { MeditationPlayerScreen(navController) }
        composable("breathing") { BreathingScreen(navController) }
        composable("soundscape") { SoundscapeScreen(navController) }
        composable("bodyscan") { BodyScanScreen(navController) }

        // Phase 4: expression
        composable("journal") { JournalScreen(navController) }
        composable("gratitude") { GratitudeScreen(navController) }
        composable("affirmations") { AffirmationScreen(navController) }
        composable("creative") { CreativeExpressionScreen(navController) }
        composable("music") { MusicTherapyScreen(navController) }
        composable("ai") { AICompanionScreen(navController) }

        // Phase 5: Reports & Settings
        composable("weekly") { WeeklyReportScreen(navController) }
        composable("monthly") { MonthlyReportScreen(navController) }
        composable("insights") { InsightsScreen(navController) }
        composable("settings") { SettingsScreen(navController) }
        composable("privacy") { PrivacyScreen(navController) }
        composable("feedback") { FeedbackScreen(navController) }
    }
}
