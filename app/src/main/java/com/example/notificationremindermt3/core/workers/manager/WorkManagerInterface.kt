package com.example.notificationremindermt3.core.workers.manager

import com.example.notificationremindermt3.core.database.table.Notification

interface WorkManagerInterface {
    fun scheduleReminderNotification(notification: Notification)
}