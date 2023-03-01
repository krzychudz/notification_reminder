package com.example.notificationremindermt3.features.dashboard.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.notificationremindermt3.core.composition_locals.LocalNavigationProvider
import com.example.notificationremindermt3.core.database.table.Notification

@Composable
fun NotificationList(notificationsData: List<Notification>) {
    val navController = LocalNavigationProvider.current
    LazyColumn(
        modifier = Modifier.fillMaxHeight(),
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        items(
            items = notificationsData,
            itemContent = { item ->
                NotificationItem(notificationData = item) {
                    navController.navigate("notification-details")
                }
            },
        )
    }
}