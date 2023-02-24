package com.example.notificationremindermt3.core.repository.notification

import com.example.notificationremindermt3.core.database.dao.NotificationDao
import com.example.notificationremindermt3.core.database.table.Notification
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class NotificationRepository(private val notificationDao: NotificationDao) :
    NotificationRepositoryInterface {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override suspend fun allNotifications(): Flow<List<Notification>> = notificationDao.getAll()

    override fun addNotification(notification: Notification) {
        coroutineScope.launch(Dispatchers.IO) {
            notificationDao.insertSingle(notification)
        }
    }
}