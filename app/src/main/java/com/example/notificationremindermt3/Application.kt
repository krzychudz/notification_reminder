package com.example.notificationremindermt3

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import com.example.notificationremindermt3.core.values.NotificationConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NotificationReminderApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val channel = NotificationChannel(
            NotificationConfig.notificationChannelId,
            NotificationConfig.notificationChannelName,
            NotificationManager.IMPORTANCE_HIGH,
        )

        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)

    }
}