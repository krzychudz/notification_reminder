package com.example.notificationremindermt3.features.notification_details.viewmodel.state

import com.example.notificationremindermt3.core.database.table.Notification

data class NotificationDetailsState(
    val notification: Notification? = null,
    val isRemoved: Boolean = false,
)
