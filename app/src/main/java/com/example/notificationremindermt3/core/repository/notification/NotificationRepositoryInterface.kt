package com.example.notificationremindermt3.core.repository.notification

import com.example.notificationremindermt3.core.database.table.Notification
import kotlinx.coroutines.flow.Flow

interface NotificationRepositoryInterface {
    suspend fun allNotifications() : Flow<List<Notification>>
    suspend fun addNotification(notification: Notification)
}