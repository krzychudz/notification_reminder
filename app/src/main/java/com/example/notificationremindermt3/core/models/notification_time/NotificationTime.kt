package com.example.notificationremindermt3.core.models.notification_time

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NotificationTime(
    val hours: Int = 12,
    val minutes: Int = 12,
) : Parcelable {
    fun formattedTime() : String {
        return "$hours:$minutes"
    }
}
