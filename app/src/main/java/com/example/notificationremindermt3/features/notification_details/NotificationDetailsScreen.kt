package com.example.notificationremindermt3.features.notification_details

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.notificationremindermt3.core.appbar.MainAppBar
import com.example.notificationremindermt3.core.composables.SpacerContainer
import com.example.notificationremindermt3.core.composables.submit_button.SubmitButton
import com.example.notificationremindermt3.core.composition_locals.LocalNavigationProvider
import com.example.notificationremindermt3.core.database.table.Notification
import com.example.notificationremindermt3.features.notification_details.viewmodel.NotificationDetailsScreenViewModel
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationDetailsScreen(notificationDetailsScreenViewModel: NotificationDetailsScreenViewModel = hiltViewModel()) {
    val navController = LocalNavigationProvider.current
    val notificationDetailsViewModelState by notificationDetailsScreenViewModel.state

    val coroutineScope = rememberCoroutineScope()

    val isNotificationRemoved = notificationDetailsScreenViewModel.state.value.isRemoved

    LaunchedEffect(key1 = isNotificationRemoved) {
        if (isNotificationRemoved) {
            navController.popBackStack()
        }
    }

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
        NotificationDetailsScreenContent(
            paddingValues,
            notificationData = notificationDetailsViewModelState.notification,
        ) {
            coroutineScope.launch {
                notificationDetailsScreenViewModel.removeNotification()
            }
        }
    }
}

@Composable
fun NotificationDetailsScreenContent(
    paddingValues: PaddingValues,
    notificationData: Notification?,
    onRemovedNotificationPressed : () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        if (notificationData == null) CircularProgressIndicator()
        else NotificationDetailsSection(notificationData) {
            onRemovedNotificationPressed()
        }
    }
}

@Composable
fun NotificationDetailsSection(
    notificationData: Notification,
    onRemovedNotificationPressed : () -> Unit
) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LabelDataInfo(label = "Name", data = notificationData.name)
        LabelDataInfo(label = "Time", data = notificationData.notificationTime.formattedTime())
        LabelDataInfo(label = "Days", data = notificationData.notificationDays.formattedDays())
        SpacerContainer(height = 8.0)
        SubmitButton(label = "Remove notification") {
            onRemovedNotificationPressed()
        }
    }
}

@Composable
fun LabelDataInfo(label: String, data: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),

        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, fontSize = 18.sp, textAlign = TextAlign.Start)
        Text(text = data, fontSize = 18.sp)
    }
}