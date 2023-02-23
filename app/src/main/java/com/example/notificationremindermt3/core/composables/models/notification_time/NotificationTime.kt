package com.example.notificationremindermt3.core.composables.models.notification_time

data class NotificationTime(
    val hours: Int = 12,
    val minutes: Int = 12,
) {
    fun formattedTime() : String {
        return "$hours:$minutes"
    }
}
