package com.example.notificationremindermt3.features.notification_details

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.notificationremindermt3.core.appbar.MainAppBar
import com.example.notificationremindermt3.core.composition_locals.LocalNavigationProvider

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationDetailsScreen() {
    val navController = LocalNavigationProvider.current
    Scaffold(
        topBar = {
            MainAppBar(
                text = "Details",
                navigationIcon = Icons.Default.ArrowBack,
                onNavigationButtonClick = {
                    navController.popBackStack()
                },
            )
        }

    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = "Notification Screen")
        }
    }
}