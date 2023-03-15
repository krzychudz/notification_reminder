package com.example.notificationremindermt3.core.workers

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.notificationremindermt3.R
import com.example.notificationremindermt3.core.values.NotificationConfig
import kotlin.random.Random

class NotificationWorker(
    private val context: Context,
    workerParameters: WorkerParameters
) : CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {
        showNotification()
        return Result.success()
    }

    private fun showNotification() {
        val notificationName = inputData.getString(WorkDataParams.notificationName)
        val notificationTitle = context.getString(R.string.notification_title)

        with(NotificationManagerCompat.from(context)) {
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            notify(Random.nextInt(),
                NotificationCompat.Builder(context, NotificationConfig.notificationChannelId)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentText(notificationName).setContentTitle(notificationTitle).build()
            )
        }
    }

}