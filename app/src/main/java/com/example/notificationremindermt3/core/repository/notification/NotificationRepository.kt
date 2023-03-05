package com.example.notificationremindermt3.core.repository.notification

import com.example.notificationremindermt3.core.database.dao.NotificationDao
import com.example.notificationremindermt3.core.database.table.Notification
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class NotificationRepository @Inject constructor(private val notificationDao: NotificationDao) :
    NotificationRepositoryInterface {

    override suspend fun allNotifications(): Flow<List<Notification>> = notificationDao.getAll()

    override suspend fun addNotification(notification: Notification) {
        notificationDao.insertSingle(notification)
    }

    override suspend fun getNotificationById(notificationId: String) =
        notificationDao.getById(notificationId)

    override suspend fun removeNotification(notification: Notification) =
        notificationDao.delete(notification)


}