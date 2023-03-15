package com.example.notificationremindermt3.core.workers.manager

import android.content.Context
import androidx.work.Data
import androidx.work.PeriodicWorkRequestBuilder
import com.example.notificationremindermt3.core.database.table.Notification
import com.example.notificationremindermt3.core.workers.NotificationWorker
import com.example.notificationremindermt3.core.workers.WorkDataParams
import java.time.Duration

class WorkManager(context: Context) : WorkManagerInterface {
    private val workManager = androidx.work.WorkManager.getInstance(context)

    override fun scheduleReminderNotification(notification: Notification) {
        val workerData =
            Data.Builder().putString(WorkDataParams.notificationName, notification.name).build()

        val scheduleNotificationWork =
            PeriodicWorkRequestBuilder<NotificationWorker>(Duration.ofMinutes(15)).setInputData(
                workerData
            ).build()

        workManager.enqueue(scheduleNotificationWork)
    }

}