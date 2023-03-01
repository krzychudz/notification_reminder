package com.example.notificationremindermt3

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notificationremindermt3.core.composition_locals.LocalNavigationProvider
import com.example.notificationremindermt3.features.dashboard.DashboardScreen
import com.example.notificationremindermt3.features.notification_details.NotificationDetailsScreen
import com.example.notificationremindermt3.ui.theme.NotificationReminderTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotificationReminderApp()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NotificationReminderApp() {
    NotificationReminderTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            CompositionLocalProvider(LocalNavigationProvider provides rememberNavController()) {

                NavHost(
                    navController = LocalNavigationProvider.current,
                    startDestination = "dashboard"
                ) {
                    composable("dashboard") { DashboardScreen() }
                    composable("notification-details") { NotificationDetailsScreen() }
                }
            }
        }
    }
}