package com.example.notificationremindermt3.features.new_notification.view_model.state

import com.example.notificationremindermt3.core.appbar.composables.models.notification_time.NotificationTime

data class AddNotificationState(
    val notificationName: String = "",
    val notificationTime: NotificationTime? = null,
    val notificationRepeatDays: String? = "",
)